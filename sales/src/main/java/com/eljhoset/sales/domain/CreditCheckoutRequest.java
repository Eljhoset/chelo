package com.eljhoset.sales.domain;

import java.util.Collection;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreditCheckoutRequest implements CheckoutRequest {
     private final Customer customer;
     private final Collection<Item> items;
}
