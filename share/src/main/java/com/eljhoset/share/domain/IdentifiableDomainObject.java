package com.eljhoset.share.domain;

import lombok.Generated;
import lombok.RequiredArgsConstructor;

@Generated
@RequiredArgsConstructor
public class IdentifiableDomainObject<I> implements DomainObject {

    private final I id;
}
