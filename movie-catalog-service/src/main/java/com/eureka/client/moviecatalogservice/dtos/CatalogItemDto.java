package com.eureka.client.moviecatalogservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatalogItemDto {

  private String name;
  private String desc;
  private int rating;

}
