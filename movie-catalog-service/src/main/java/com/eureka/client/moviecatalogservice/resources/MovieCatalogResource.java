package com.eureka.client.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.client.moviecatalogservice.dtos.CatalogItemDto;

@RequestMapping("/movie-catalog-api")
@RestController
public class MovieCatalogResource {

  @GetMapping("/{userId}")
  public List<CatalogItemDto> getCatalog(@PathVariable final String userId) {
    // @formatter:off
    return Collections.singletonList(
          CatalogItemDto.builder()
            .name("Movie 1")
            .desc("Good Movie")
            .rating(1)
            .build()
        );
    // @formatter:on
  }

}
