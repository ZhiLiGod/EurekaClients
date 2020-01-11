package com.eureka.client.moviecatalogservice.services;

import java.util.List;

import com.eureka.client.moviecatalogservice.entities.AspNetUsers;

public interface UserService {

  List<AspNetUsers> findAll();

  AspNetUsers findByUserName(String userName);

}
