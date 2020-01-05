package com.eureka.client.movieinfoservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.client.movieinfoservice.dtos.MovieDto;

@RestController
@RequestMapping("/movie-info-api")
public class MovieInfoResource {

  @GetMapping("/{movieId}")
  public MovieDto getMovieInfo(@PathVariable final String movieId) {
    // @formatter:off
    return MovieDto.builder()
        .name("Saw")
        .movieId("movie_1")
        .build();
    // @formatter:on
  }

}
