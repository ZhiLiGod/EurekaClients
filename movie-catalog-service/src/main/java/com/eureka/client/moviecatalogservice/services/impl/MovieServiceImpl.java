package com.eureka.client.moviecatalogservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eureka.client.moviecatalogservice.dtos.MovieDto;
import com.eureka.client.moviecatalogservice.services.MovieService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

  @Autowired
  private RestTemplate restTemplate;

  @Override
  @HystrixCommand(fallbackMethod = "getFallBackMovie")
  public MovieDto getMovie(@NonNull final String movieId) {
    return restTemplate.getForObject("http://movie-info-service:8082/movie-info-api/" + movieId, MovieDto.class);
  }

  public MovieDto getFallBackMovie(final String movieId) {
    log.info("MovieId: " + movieId);
    return MovieDto.builder().name("Zhi").build();
  }
  
  @HystrixCommand(
    fallbackMethod = "getBuyerOpenDealsFallBack",
    commandProperties = {
      @HystrixProperty(name = "execution.isolation.strategy",value = "SEMAPHORE"), // by default is isolated by Thread, but will lose session which is used in OAuth2RestTemplate
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000") // do fallback if more than 20s
    }
  )

}
