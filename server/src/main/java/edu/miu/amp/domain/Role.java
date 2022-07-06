package edu.miu.amp.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {
  ADMIN, FACULTY, STUDENT;

  @JsonCreator
  public static Role create(String value) {
    return Role.valueOf(value.toUpperCase());
  }
}
