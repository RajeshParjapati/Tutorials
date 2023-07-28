package com.potters.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Entity
@Table(name = "ADDRESS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Integer id;
  private String street;
  private String city;
  private String country;
  private String pinCode;
}
