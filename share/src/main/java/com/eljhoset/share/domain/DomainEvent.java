package com.eljhoset.share.domain;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public abstract class DomainEvent implements DomainObject {

    private final LocalDateTime when;

    public DomainEvent() {
        this.when = LocalDateTime.now();
    }

    public abstract String getType();
}
