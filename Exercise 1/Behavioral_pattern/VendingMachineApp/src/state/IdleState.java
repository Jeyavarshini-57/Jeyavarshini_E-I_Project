package state;

import exception.VendingMachineException;
import service.VendingMachine;
import util.LoggerUtil;

public class IdleState implements VendingMachineState {
    private final VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem(int itemNumber) throws VendingMachineException {
        if (!machine.isValidItem(itemNumber)) {
            throw new VendingMachineException("Invalid item or out of stock.");
        }
        machine.setSelectedItem(itemNumber);
        LoggerUtil.info("Item selected: " + machine.getItemName(itemNumber) + " (Rs." + machine.getItemPrice(itemNumber) + ")");
        machine.setState(machine.getHasMoneyState());
    }

    @Override
    public void insertMoney(int amount) throws VendingMachineException {
        throw new VendingMachineException("Select an item first!");
    }

    @Override
    public void dispenseItem() throws VendingMachineException {
        throw new VendingMachineException("Select an item and pay first!");
    }
}
