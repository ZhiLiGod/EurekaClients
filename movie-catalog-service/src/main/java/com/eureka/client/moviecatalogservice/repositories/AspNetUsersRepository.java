package com.eureka.client.moviecatalogservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eureka.client.moviecatalogservice.entities.AspNetUsers;

public interface AspNetUsersRepository extends JpaRepository<AspNetUsers, String> {

  AspNetUsers findByUserName(String userName);

}
