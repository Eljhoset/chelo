package com.eljhoset.sales.application.service;

import com.eljhoset.sales.application.command.CheckoutInCash;
import com.eljhoset.sales.application.repository.CashSaleRepository;
import com.eljhoset.sales.application.repository.CashierRepository;
import com.eljhoset.sales.domain.CashCheckoutRequest;
import com.eljhoset.sales.domain.CashSale;
import com.eljhoset.share.application.ApplicationService;
import com.eljhoset.share.application.DomainEventPublisher;
import com.eljhoset.share.domain.model.Money;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CashSaleCheckouter implements ApplicationService<CheckoutInCash> {

    private final CashSaleRepository saleRepository;
    private final CashierRepository cashierRepository;
    private final DomainEventPublisher domainEventPublisher;

    @Override
    public void execute(final CheckoutInCash checkoutInCash) {
        final var cashier = cashierRepository.findById(checkoutInCash.getCashier())
                .orElseThrow(IllegalArgumentException::new);
        final var money = Money.from(checkoutInCash.getCashAmount(), Money.Currency.valueOf(checkoutInCash.getCurrency()));
        
        final var request = new CashCheckoutRequest(money, checkoutInCash.getItems());
        final var sale = cashier.<CashSale, CashCheckoutRequest>checkout(request);
        saleRepository.save(sale);
        domainEventPublisher.publish(sale.events());
    }

}
