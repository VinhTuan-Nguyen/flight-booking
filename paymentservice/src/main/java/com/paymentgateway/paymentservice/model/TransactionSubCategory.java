package com.paymentgateway.paymentservice.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionSubCategory extends JpaRepository<SubCategory, Long> {
}