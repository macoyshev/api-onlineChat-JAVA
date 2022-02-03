package com.macoyshev.restAPI.store.entities;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum Role {
  USER(Set.of(Permission.USER_READ)),
  ADMIN(Set.of(Permission.USER_READ, Permission.USER_WRITE));

  private Set<Permission> permissions;

  public Set<GrantedAuthority> getAuthorities() {
    return permissions.stream()
      .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
      .collect(Collectors.toSet());
  }
}
