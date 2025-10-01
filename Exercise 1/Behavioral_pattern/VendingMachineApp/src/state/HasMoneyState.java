package state;

import exception.VendingMachineException;
import service.VendingMachine;
import util.LoggerUtil;

public class HasMoneyState implements VendingMachineState {
    private final VendingMachine machine;

    public HasMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem(int itemNumber) throws VendingMachineException {
        throw new VendingMachineException("Item already selected. Please pay.");
    }

    @Override
    public void insertMoney(int amount) throws Exception {
        int item = machine.getSelectedItem();
        int price = machine.getItemPrice(item);

        machine.addBalance(amount);
        LoggerUtil.info("Inserted Rs." + amount + ". Current balance: Rs." + machine.getBalance());

        if (machine.getBalance() >= price) {
            machine.setState(machine.getDispenseState());
            machine.dispenseItem();
        } else {
            throw new VendingMachineException("Insufficient balance. Please insert at least Rs." + (price - machine.getBalance()) + " more.");
        }
    }

    @Override
    public void dispenseItem() throws VendingMachineException {
        throw new VendingMachineException("Please insert enough money first!");
    }
}
