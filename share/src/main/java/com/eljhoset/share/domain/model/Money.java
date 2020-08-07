package com.eljhoset.share.domain.model;

import com.eljhoset.share.domain.ValueObject;
import com.eljhoset.share.domain.exception.IllegalMoneyDecimalException;
import com.eljhoset.share.domain.exception.NegativeMoneyException;
import lombok.Getter;

/**
 *
 * @author jd-jd
 */
@Getter
public class Money implements ValueObject {

    public static Money from(final float money, final Currency currency) {
        return new Money(money, currency);
    }
    private final float money;
    private final Currency currency;

    private Money(float money, Currency currency) {
        if (money < 0) {
            throw new NegativeMoneyException(String.format("%f is a negative value", money));
        }
        if (money * 100 % 1 > 0) {
            throw new IllegalMoneyDecimalException(String.format("%f should not have more that two decimals", money));
        }
        this.money = money;
        this.currency = currency;
    }

    public static enum Currency {
        DOP, USD
    }

}
