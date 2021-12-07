package core.entity;

import java.util.Calendar;

import helpers.credit_card.InvalidCreditCard;

public class CreditCard {
    private String number;
    private String name;
    private int expirationMonth;
    private int expirationYear;
    private int CVV;

    public CreditCard(String number, String name, int expirationMonth, int expirationYear, int CVV)
            throws InvalidCreditCard {
        this.number = number.replaceAll("[^0-9]+", "");
        this.name = name;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.CVV = CVV;
        isValid();
    }

    public boolean isValid() throws InvalidCreditCard {
        if (!luhnCheck(this.number))
            throw new InvalidCreditCard("Invalid credit card number!");
        if (!isExpirationMonthValid())
            throw new InvalidCreditCard("Invalid expiration month!");
        if (!isExpirationYearValid())
            throw new InvalidCreditCard("Invalid expiration year!");
        else
            return true;
    }

    public boolean isExpirationMonthValid() {
        return expirationMonth > 0 && expirationMonth < 13;
    }

    public boolean isExpirationYearValid() {
        Calendar year = Calendar.getInstance();
        return expirationYear >= year.get(Calendar.YEAR);
    }

    public boolean luhnCheck(String number) {
        int digits = number.length();
        int odd_or_even = digits & 1;
        long sum = 0;

        for (int i = 0; i < digits; i++) {
            int digit = 0;
            try {
                digit = Integer.parseInt(number.charAt(i) + "");
            } catch (NumberFormatException e) {
                return false;
            }

            if (((i & 1) ^ odd_or_even) == 0) { // not
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
        }

        return (sum == 0) ? false : (sum % 10 == 0);
    }
}