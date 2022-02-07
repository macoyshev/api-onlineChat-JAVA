package com.macoyshev.restAPI.security.services;

import com.macoyshev.restAPI.store.entities.UserEntity;
import com.macoyshev.restAPI.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class MainUserDetailService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = userRepository.findByName(username)
      .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return MainUserDetails.build(user);
  }
}
