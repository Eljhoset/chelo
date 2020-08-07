package com.eljhoset.sales.domain;

import com.eljhoset.share.domain.Entity;
import java.util.UUID;

public abstract class Cashier extends Entity<UUID> {

    public Cashier(UUID id) {
        super(id);
    }

    public abstract <T extends Sale, R extends CheckoutRequest> T checkout(R request);

}
