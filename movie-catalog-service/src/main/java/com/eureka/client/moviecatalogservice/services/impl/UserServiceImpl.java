package com.eureka.client.moviecatalogservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.client.moviecatalogservice.entities.AspNetUsers;
import com.eureka.client.moviecatalogservice.repositories.AspNetUsersRepository;
import com.eureka.client.moviecatalogservice.services.UserService;
import com.eureka.client.moviecatalogservice.utils.RedisUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private AspNetUsersRepository aspNetUsersRepository;

  @Autowired
  private RedisUtil redisUtil;

  @Override
  public List<AspNetUsers> findAll() {
    List<AspNetUsers> users = (List<AspNetUsers>) redisUtil.get("allUsers");

    if (null == users) {
      log.info("NO CACHE");
      users = aspNetUsersRepository.findAll();
      redisUtil.set("allUsers", users);
    }

    return users;
  }

  @Override
  public AspNetUsers findByUserName(String userName) {
    return aspNetUsersRepository.findByUserName(userName);
  }

}
