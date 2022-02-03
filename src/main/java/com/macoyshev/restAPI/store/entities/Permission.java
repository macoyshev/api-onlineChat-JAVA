package com.macoyshev.restAPI.store.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Permission {
  USER_WRITE("user:write"),
  USER_READ("user:read");

  private String permission;
}
