package com.macoyshev.restAPI.security.services;

import com.macoyshev.restAPI.store.entities.UserEntity;
import com.macoyshev.restAPI.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = userRepository.findByName(username)
      .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return MyUserDetail.build(user);
  }
}
