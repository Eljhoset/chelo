package com.eljhoset.sales.domain;

import com.eljhoset.share.domain.model.Money;
import java.util.Collection;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CashCheckoutRequest implements CheckoutRequest {

    private final Money amout;
    private final Collection<Item> items;
}
