package com.eljhoset.sales.application.service;

import com.eljhoset.sales.application.command.CheckoutInCredit;
import com.eljhoset.sales.application.repository.CashierRepository;
import com.eljhoset.sales.application.repository.CreditSaleRepository;
import com.eljhoset.sales.application.repository.CustomerRepository;
import com.eljhoset.sales.domain.CreditCheckoutRequest;
import com.eljhoset.sales.domain.CreditSale;
import com.eljhoset.share.application.ApplicationService;
import com.eljhoset.share.application.DomainEventPublisher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreditSaleCheckouter implements ApplicationService<CheckoutInCredit> {

    private final CreditSaleRepository saleRepository;
    private final CashierRepository cashierRepository;
    private final CustomerRepository customerRepository;
    private final DomainEventPublisher domainEventPublisher;

    @Override
    public void execute(final CheckoutInCredit checkoutInCredit) {
        final var cashier = cashierRepository.findById(checkoutInCredit.getCashier())
                .orElseThrow(IllegalArgumentException::new);
        final var customer = customerRepository.findById(checkoutInCredit.getCustomer())
                .orElseThrow(IllegalArgumentException::new);

        final var request = new CreditCheckoutRequest(customer, checkoutInCredit.getItems());
        final var sale = cashier.<CreditSale, CreditCheckoutRequest>checkout(request);

        saleRepository.save(sale);
        domainEventPublisher.publish(sale.events());
    }

}
