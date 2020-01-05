package com.eureka.client.ratinginfoservice.resources;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.client.ratinginfoservice.dtos.RatingDto;
import com.eureka.client.ratinginfoservice.dtos.RatingsDto;

@RestController
@RequestMapping("/rating-info-api")
public class RatingInfoResource {

  @GetMapping("/{movieId}")
  public RatingDto getRating(@PathVariable final String movieId) {
    // @formatter:off
    return RatingDto.builder()
        .movieId(movieId)
        .rating(5)
        .build();
    // @formatter:on
  }

  @GetMapping
  public RatingsDto getRatings() {
    // @formatter:off
    return RatingsDto.builder().ratings(Arrays.asList(
        RatingDto.builder().movieId("1234").rating(4).build(),
        RatingDto.builder().movieId("2345").rating(3).build()
      )).build();
    // @formatter:on
  }

}
