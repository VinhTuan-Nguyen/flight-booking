package com.paymentgateway.paymentservice.model;

import java.time.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sub_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "category_code")
  private String categoryCode;

  @Column(name = "sub_category_code")
  private String subCategoryCode;

  @Column(name = "sub_category_name")
  private String subCategoryName;


}