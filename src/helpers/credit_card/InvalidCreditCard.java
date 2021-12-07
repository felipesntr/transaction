package helpers.credit_card;

public class InvalidCreditCard extends Exception {
    public InvalidCreditCard(String message) {
        super(message);
    }
}
