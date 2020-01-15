package com.eureka.client.moviecatalogservice.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartDto {

  private BigDecimal amount;
  private BigDecimal totalDiscount;

  public boolean isGreaterThanTwoHundered() {
    return BigDecimal.valueOf(200).compareTo(amount) < 0;
  }

}
