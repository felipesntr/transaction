package core.entity;

import helpers.transaction.InvalidTransaction;

public class Transaction {
    private String accountID;
    private float amount;
    private CreditCard creditCard;

    public Transaction(String accountID, float amount) throws InvalidTransaction {
        this.accountID = accountID;
        this.amount = amount;
        isValid();
    }

    public boolean isValid() throws InvalidTransaction {
        if (amount <= 0)
            throw new InvalidTransaction("Amount must be greater than 0");
        if (amount > 10000)
            throw new InvalidTransaction("Amount must be less than 10000");
        return true;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
