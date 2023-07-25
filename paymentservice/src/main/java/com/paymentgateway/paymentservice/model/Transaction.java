package com.paymentgateway.paymentservice.model;

import java.time.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "transaction_code")
  private String transactionCode;

  @Column(name = "process_date")
  private LocalDateTime processDate;

  @Column(name = "transaction_type")
  private String transactionType;

  @Column(name = "amount")
  private float amount;
}