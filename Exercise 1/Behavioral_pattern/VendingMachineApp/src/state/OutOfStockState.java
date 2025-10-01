package state;

import exception.VendingMachineException;
import service.VendingMachine;

public class OutOfStockState implements VendingMachineState {

    public OutOfStockState(VendingMachine machine) {
    }

    @Override
    public void insertMoney(int amount) throws VendingMachineException {
        throw new VendingMachineException("Machine is out of stock.");
    }

    @Override
    public void selectItem(int itemNumber) throws VendingMachineException {
        throw new VendingMachineException("Machine is out of stock.");
    }

    @Override
    public void dispenseItem() throws VendingMachineException {
        throw new VendingMachineException("Machine is out of stock.");
    }
}
