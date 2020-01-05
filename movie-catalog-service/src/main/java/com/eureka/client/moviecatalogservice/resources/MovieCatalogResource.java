package com.eureka.client.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.client.moviecatalogservice.dtos.CatalogItemDto;
import com.eureka.client.moviecatalogservice.dtos.MovieDto;
import com.eureka.client.moviecatalogservice.dtos.RatingsDto;
import com.eureka.client.moviecatalogservice.services.MovieService;
import com.eureka.client.moviecatalogservice.services.RatingsService;

@RequestMapping("/movie-catalog-api")
@RestController
public class MovieCatalogResource {

  @Autowired
  private RatingsService ratingsService;

  @Autowired
  private MovieService movieService;

  @GetMapping("/{userId}")
  public List<CatalogItemDto> getCatalog(@PathVariable final String userId) {
    RatingsDto ratings = ratingsService.getRatings();

    return ratings.getRatings().stream().map(r -> {
      MovieDto dto = movieService.getMovie(r.getMovieId());

      // @formatter:off
      return CatalogItemDto.builder()
          .name(dto.getName())
          .rating(r.getRating())
          .build();
      // @formatter:on
    }).collect(Collectors.toList());
  }

}
