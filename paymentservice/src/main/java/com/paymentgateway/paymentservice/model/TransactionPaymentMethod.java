package com.paymentgateway.paymentservice.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPaymentMethod extends JpaRepository<PaymentMethod, Long> {
}