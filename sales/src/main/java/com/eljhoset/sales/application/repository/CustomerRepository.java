package com.eljhoset.sales.application.repository;

import com.eljhoset.sales.domain.Customer;
import com.eljhoset.share.application.Repository;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends Repository {

    Optional<Customer> findById(UUID id);
}
