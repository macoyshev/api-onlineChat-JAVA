package com.macoyshev.restAPI.store.entities;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum Role {
  ROLE_USER(Set.of(Permission.USER_READ)),
  ROLE_ADMIN(Set.of(Permission.USER_READ, Permission.USER_WRITE));

  private Set<Permission> permissions;

  public Set<GrantedAuthority> getAuthorities() {
    return permissions.stream()
      .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
      .collect(Collectors.toSet());
  }
}
