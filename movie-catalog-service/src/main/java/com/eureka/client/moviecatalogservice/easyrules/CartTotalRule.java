package com.eureka.client.moviecatalogservice.easyrules;

import java.math.BigDecimal;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.eureka.client.moviecatalogservice.dtos.CartDto;

@Rule(name = "cart total rule", description = "Give 10% off when shopping cart is greater than $200")
public class CartTotalRule {

  @Condition
  public boolean cartTotal(@Fact("cart") CartDto cart) {
    return cart.isGreaterThanTwoHundered();
  }

  @Action
  public void giveDiscount(@Fact("cart") CartDto cart) {
    cart.setTotalDiscount(cart.getAmount().multiply(BigDecimal.valueOf(0.1)));
  }

}
