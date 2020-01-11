package com.eureka.client.moviecatalogservice.resources;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.client.moviecatalogservice.entities.AspNetUsers;
import com.eureka.client.moviecatalogservice.services.UserService;

@RestController
@RequestMapping("/user")
public class UserResource {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<AspNetUsers> getAllUsers() {
    // TEST HIGH CONCURRENT
    ExecutorService executorService = Executors.newFixedThreadPool(25);

    for (int i = 0; i < 10000; i++) {
      executorService.submit(new Runnable() {

        @Override
        public void run() {
          userService.findAll();
        }

      });
    }

    return userService.findAll();
  }

  @GetMapping("/{userName:.+}")
  public AspNetUsers getUserByUserName(@PathVariable final String userName) {
    return userService.findByUserName(userName);
  }

}
