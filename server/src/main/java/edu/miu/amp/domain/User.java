package edu.miu.amp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;

  private String lastName;

  private String email;

  private String password;
  @Column(columnDefinition="BOOLEAN DEFAULT true")
  private boolean isActive;
  @Enumerated(EnumType.STRING)
  private Role role;

}
