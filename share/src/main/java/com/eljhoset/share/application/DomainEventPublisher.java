package com.eljhoset.share.application;

import com.eljhoset.share.domain.DomainEvent;
import java.util.Collection;

public interface DomainEventPublisher {

    void publish(DomainEvent event);

    default void publish(Collection<DomainEvent> events) {
        events.forEach(this::publish);
    }
}
