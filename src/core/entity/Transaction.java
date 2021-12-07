package core.entity;

import helpers.transaction.InvalidTransaction;

public class Transaction {
    private String id;
    private String accountID;
    private float amount;
    private CreditCard creditCard;

    public Transaction(String id, String accountID, float amount) throws InvalidTransaction {
        this.id = id;
        this.accountID = accountID;
        this.amount = amount;
        isValid();
    }

    public boolean isValid() throws InvalidTransaction {
        if (amount <= 0)
            throw new InvalidTransaction("Amount must be greater than 0");
        return true;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
