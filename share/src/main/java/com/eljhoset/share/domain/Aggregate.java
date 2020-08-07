package com.eljhoset.share.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Aggregate<I> extends IdentifiableDomainObject<I> {

    private final Collection<DomainEvent> events = new ArrayList<>();

    public Aggregate(I id) {
        super(id);
    }

    protected void addEvent(DomainEvent event) {
        events.add(event);
    }

    public Collection<DomainEvent> events() {
        return Collections.unmodifiableCollection(events);
    }

}
