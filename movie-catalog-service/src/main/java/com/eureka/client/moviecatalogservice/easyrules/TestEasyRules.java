package com.eureka.client.moviecatalogservice.easyrules;

import java.math.BigDecimal;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

import com.eureka.client.moviecatalogservice.dtos.CartDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestEasyRules {

  public static void main(String[] args) {
    Facts facts = new Facts();
    CartDto cart = new CartDto();

    cart.setAmount(BigDecimal.valueOf(500));
    facts.put("cart", cart);

    Rules rules = new Rules();
    rules.register(new CartTotalRule());

    RulesEngine rulesEngine = new DefaultRulesEngine();
    rulesEngine.fire(rules, facts);

    log.info("amount: " + cart.getAmount());
    log.info("discount: " + cart.getTotalDiscount());
  }

}
