package com.eureka.client.moviecatalogservice.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "AspNetUsers")
public class AspNetUsers implements Serializable {

  private static final long serialVersionUID = -2547133917902512841L;

  @Id
  @Column(unique = true)
  private String id;

  private String userName;

  private LocalDateTime registrationDate;

}
