package com.eureka.client.ratinginfoservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.client.ratinginfoservice.dtos.RatingDto;

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

}
