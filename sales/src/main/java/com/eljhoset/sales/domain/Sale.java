package com.eljhoset.sales.domain;

import com.eljhoset.share.domain.Aggregate;
import java.util.UUID;

public class Sale extends Aggregate<UUID> {

    public Sale(UUID id) {
        super(id);
    }

}
