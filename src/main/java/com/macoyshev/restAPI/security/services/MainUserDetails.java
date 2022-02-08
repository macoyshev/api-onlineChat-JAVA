package com.macoyshev.restAPI.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.macoyshev.restAPI.store.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;


public class MainUserDetails implements UserDetails {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  @JsonIgnore
  private String password;

  private final Collection<? extends GrantedAuthority> authorities;

  private MainUserDetails(Long id, String name, String password, Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.authorities = authorities;
  }

  public static MainUserDetails build(UserEntity user) {
    return new MainUserDetails(
            user.getId(),
            user.getName(),
            user.getPassword(),
            user.getRole().getAuthorities()
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
