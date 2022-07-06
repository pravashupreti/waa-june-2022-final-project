package edu.miu.amp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class JobAdvertisement {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String tags;
  String state;
  String city;
  String companyName;

}
