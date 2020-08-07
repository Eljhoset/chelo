package com.eljhoset.sales.application.command;

import com.eljhoset.sales.domain.Item;
import com.eljhoset.share.application.Command;
import java.util.Collection;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CheckoutInCredit implements Command {

    private final UUID cashier;
    private final UUID customer;
    private final Collection<Item> items;
}
