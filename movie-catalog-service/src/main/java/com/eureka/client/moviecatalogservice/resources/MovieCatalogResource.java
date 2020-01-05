package com.eureka.client.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eureka.client.moviecatalogservice.dtos.CatalogItemDto;
import com.eureka.client.moviecatalogservice.dtos.MovieDto;
import com.eureka.client.moviecatalogservice.dtos.RatingsDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RequestMapping("/movie-catalog-api")
@RestController
public class MovieCatalogResource {

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/{userId}")
  @HystrixCommand(fallbackMethod = "getFallBackCatalog")
  public List<CatalogItemDto> getCatalog(@PathVariable final String userId) {
    RatingsDto ratings = restTemplate.getForObject("http://rate-info-service:8083/rating-info-api/", RatingsDto.class);

    return ratings.getRatings().stream().map(r -> {
      MovieDto dto = restTemplate.getForObject("http://movie-info-service:8082/movie-info-api/" + r.getMovieId(), MovieDto.class);

      // @formatter:off
      return CatalogItemDto.builder()
          .name(dto.getName())
          .rating(r.getRating())
          .build();
      // @formatter:on
    }).collect(Collectors.toList());
  }

  public List<CatalogItemDto> getFallBackCatalog(final String userId) {
    return Collections.emptyList();
  }

}
