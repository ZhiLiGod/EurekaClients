package com.eureka.client.moviecatalogservice.services;

import com.eureka.client.moviecatalogservice.dtos.MovieDto;

public interface MovieService {

  MovieDto getMovie(String movieId);

}
