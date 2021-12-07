package tests;

import java.util.Calendar;

import org.junit.Test;

import core.entity.CreditCard;

import helpers.credit_card.InvalidCreditCard;

public class CreditCardTest {
    @Test(expected = InvalidCreditCard.class)
    public void should_throw_if_an_invalid_credit_card_is_provided() throws InvalidCreditCard {
        CreditCard creditCard = new CreditCard("5322060731234446", "Marina Silva", 12, 2024, 123);
    }

    @Test(expected = InvalidCreditCard.class)
    public void should_throw_if_an_invalid_expiration_month_is_provided() throws InvalidCreditCard {
        CreditCard creditCard = new CreditCard("5294 9462 3896 2151", "Marina Silva", 13, 2024, 123);
    }

    @Test(expected = InvalidCreditCard.class)
    public void should_throw_if_an_invalid_expiration_year_is_provided() throws InvalidCreditCard {
        Calendar prevYear = Calendar.getInstance();
        prevYear.add(Calendar.YEAR, -1);
        CreditCard creditCard = new CreditCard("5294 9462 3896 2151", "Marina Silva", 7, prevYear.get(Calendar.YEAR),
                123);
    }
}
