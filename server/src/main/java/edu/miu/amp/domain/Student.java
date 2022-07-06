package edu.miu.amp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String major;
  private String email;
  private String firstName;
  private String lastname;
  private String password;
  private Float gpa;
  private LocalDate lastLoggedInAt;
  private Boolean active;
}
