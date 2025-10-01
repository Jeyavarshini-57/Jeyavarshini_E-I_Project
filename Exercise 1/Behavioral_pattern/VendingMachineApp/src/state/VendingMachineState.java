package state;

import exception.VendingMachineException;

public interface VendingMachineState {
    void selectItem(int itemNumber) throws VendingMachineException;
    void insertMoney(int amount) throws VendingMachineException, Exception;
    void dispenseItem() throws VendingMachineException;
}
