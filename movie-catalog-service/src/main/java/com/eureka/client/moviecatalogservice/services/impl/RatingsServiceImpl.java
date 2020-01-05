package com.eureka.client.moviecatalogservice.services.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eureka.client.moviecatalogservice.dtos.RatingDto;
import com.eureka.client.moviecatalogservice.dtos.RatingsDto;
import com.eureka.client.moviecatalogservice.services.RatingsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RatingsServiceImpl implements RatingsService {

  @Autowired
  private RestTemplate restTemplate;

  @Override
  @HystrixCommand(fallbackMethod = "getFallBackRatings")
  public RatingsDto getRatings() {
    return restTemplate.getForObject("http://rate-info-service:8083/rating-info-api/", RatingsDto.class);
  }

  public RatingsDto getFallBackRatings() {
    RatingsDto dto = new RatingsDto();
    dto.setRatings(Arrays.asList(RatingDto.builder().movieId("4321").rating(2).build()));
    return dto;
  }

}
