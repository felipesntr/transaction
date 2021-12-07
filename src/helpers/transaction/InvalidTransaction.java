package helpers.transaction;

public class InvalidTransaction extends Exception {
    public InvalidTransaction(String message) {
        super(message);
    }
}
