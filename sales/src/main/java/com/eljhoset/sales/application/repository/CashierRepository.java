package com.eljhoset.sales.application.repository;

import com.eljhoset.sales.domain.Cashier;
import com.eljhoset.share.application.Repository;
import java.util.Optional;
import java.util.UUID;

public interface CashierRepository extends Repository {

    Optional<Cashier> findById(UUID id);
}
