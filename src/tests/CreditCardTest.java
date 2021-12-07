package tests;

import org.junit.Test;

import core.entity.CreditCard;
import helpers.credit_card.InvalidCreditCard;

public class CreditCardTest {
    @Test(expected = InvalidCreditCard.class)
    public void should_throw_if_an_invalid_credit_card_is_provided() throws InvalidCreditCard {
        CreditCard creditCard = new CreditCard("5322060731234446", "Marina Silva", 12, 2024, 123);
    }
}
