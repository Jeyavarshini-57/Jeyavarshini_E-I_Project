package service;

import model.Item;
import state.*;
import util.LoggerUtil;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private final VendingMachineState idleState;
    private final VendingMachineState hasMoneyState;
    private final VendingMachineState dispenseState;

    private VendingMachineState currentState;
    private final Map<Integer, Item> items;
    private int balance;
    private int selectedItem;

    public VendingMachine() {
        items = new HashMap<>();
        balance = 0;
        selectedItem = -1;

        idleState = new IdleState(this);
        hasMoneyState = new HasMoneyState(this);
        dispenseState = new DispenseState(this);

        currentState = idleState;
    }

    public void addItem(int id, Item item) {
        items.put(id, item);
    }

    public void showItems() {
        LoggerUtil.info("Available Items:");
        items.forEach((id, item) -> 
            System.out.println(id + ". " + item.getName() + " - Rs." + item.getPrice() + " (Qty: " + item.getQuantity() + ")")
        );
    }

    public boolean isValidItem(int itemNumber) {
        return items.containsKey(itemNumber) && items.get(itemNumber).getQuantity() > 0;
    }

    public String getItemName(int itemNumber) {
        return items.get(itemNumber).getName();
    }

    public int getItemPrice(int itemNumber) {
        return items.get(itemNumber).getPrice();
    }

    public void dispense(int itemNumber) {
        items.get(itemNumber).reduceQuantity();
        balance -= items.get(itemNumber).getPrice();
    }

    public void addBalance(int amount) { balance += amount; }
    public int getBalance() { return balance; }
    public void resetBalance() { balance = 0; }

    public void setSelectedItem(int item) { selectedItem = item; }
    public int getSelectedItem() { return selectedItem; }
    public void resetSelectedItem() { selectedItem = -1; }

    public void setState(VendingMachineState state) { currentState = state; }
    public VendingMachineState getIdleState() { return idleState; }
    public VendingMachineState getHasMoneyState() { return hasMoneyState; }
    public VendingMachineState getDispenseState() { return dispenseState; }

    public void selectItem(int item) throws Exception { currentState.selectItem(item); }
    public void insertMoney(int amount) throws Exception { currentState.insertMoney(amount); }
    public void dispenseItem() throws Exception { currentState.dispenseItem(); }
}
