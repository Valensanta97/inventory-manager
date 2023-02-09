package tech.konex.inventorymanagement.exceptions;

public class MedicineNotFoundException  extends RuntimeException{
    public MedicineNotFoundException(String message) {
        super(message);
    }
}
