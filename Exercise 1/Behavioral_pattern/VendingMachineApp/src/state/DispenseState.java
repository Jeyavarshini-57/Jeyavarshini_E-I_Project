package state;

import exception.VendingMachineException;
import service.VendingMachine;
import util.LoggerUtil;

public class DispenseState implements VendingMachineState {
    private final VendingMachine machine;

    public DispenseState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem(int itemNumber) throws VendingMachineException {
        throw new VendingMachineException("Wait, dispensing current item.");
    }

    @Override
    public void insertMoney(int amount) throws VendingMachineException {
        throw new VendingMachineException("Wait, dispensing current item.");
    }

    @Override
    public void dispenseItem() {
        int item = machine.getSelectedItem();
        machine.dispense(item);
        LoggerUtil.info("Item dispensed: " + machine.getItemName(item));

        if (machine.getBalance() > 0) {
            LoggerUtil.info("Balance returned: Rs." + machine.getBalance());
            machine.resetBalance();
        }

        machine.resetSelectedItem();
        machine.setState(machine.getIdleState());
    }
}
