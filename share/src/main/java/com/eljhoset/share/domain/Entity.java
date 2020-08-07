package com.eljhoset.share.domain;

public abstract class Entity<I> extends IdentifiableDomainObject<I> {

    public Entity(I id) {
        super(id);
    }

}
