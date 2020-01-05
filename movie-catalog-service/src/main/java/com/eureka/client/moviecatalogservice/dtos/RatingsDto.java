package com.eureka.client.moviecatalogservice.dtos;

import java.util.List;

import lombok.Data;

@Data
public class RatingsDto {

  private List<RatingDto> ratings;

}
