package tests;

import org.junit.Test;

import core.entity.Transaction;
import helpers.transaction.InvalidTransaction;

public class TransactionTest {
    /*
     * Business Rule
     * 1. The transaction amount must be greater than 0
     * 2. The transaction amount must be less than or equal to 10000
     */
    @Test(expected = InvalidTransaction.class)
    public void should_throw_if_the_amount_is_less_than_1() throws InvalidTransaction {
        Transaction transaction = new Transaction("AccountID", 0);
    }

    @Test(expected = InvalidTransaction.class)
    public void should_throw_if_the_amount_is_greater_than_10000() throws InvalidTransaction {
        Transaction transaction = new Transaction("AccountID", 10001);
    }
}
