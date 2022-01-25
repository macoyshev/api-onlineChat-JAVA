package com.macoyshev.restAPI.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.macoyshev.restAPI.store.entities.UserEntity;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetail implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public MyUserDetail(Long id, String name, String password, Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.authorities = authorities;
  }

  public static MyUserDetail build(UserEntity user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
      .map(role -> new SimpleGrantedAuthority(role.getRole().name()))
      .collect(Collectors.toList());

    return new MyUserDetail(
      user.getId(),
      user.getName(),
      user.getPassword(),
      authorities
    );
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return name;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
