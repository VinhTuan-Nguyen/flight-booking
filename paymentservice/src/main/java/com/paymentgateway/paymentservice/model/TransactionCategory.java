package com.paymentgateway.paymentservice.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionCategory extends JpaRepository<Category, Long> {
}