package com.eljhoset.share.domain.model;

import com.eljhoset.share.domain.exception.IllegalMoneyDecimalException;
import com.eljhoset.share.domain.exception.NegativeMoneyException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("Instatiating a instance with a negative value")
    public void negativeValue_shouldTrhowNegativeMoneyException() {
        final float value = -1;
        var exception = assertThrows(NegativeMoneyException.class, () -> {
            Money.from(value, Money.Currency.USD);
        });
        assertThat("Exception message malformed", exception.getMessage(), is(String.format("%f is a negative value", value)));
    }

    @Test
    @DisplayName("Instatiating a instance with more than two decimal")
    public void invalidValue_shouldTrhowNegativeMoneyException() {
        final float value = 2.335f;
        var exception = assertThrows(IllegalMoneyDecimalException.class, () -> {
            Money.from(value, Money.Currency.USD);
        });
        assertThat("Exception message malformed", exception.getMessage(), is(String.format("%f should not have more that two decimals", value)));
    }

    @Test
    @DisplayName("Instatiating a instance with two decimal")
    public void validValue_shouldIntantiate() {
        final float value = 2.33f;
        final var money = Money.from(value, Money.Currency.USD);
        assertNotNull(money);
    }

}
