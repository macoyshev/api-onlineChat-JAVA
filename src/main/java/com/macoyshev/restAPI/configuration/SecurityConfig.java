package com.macoyshev.restAPI.configuration;

import com.macoyshev.restAPI.security.services.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.client.HttpClientErrorException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private MyUserDetailService userDetailService;

  //TODO: implement authEntryPoint
  //private AuthEntryPointJwt unauthorized;

  //TODO: finish configuration
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable()
      .exceptionHandling();
  }

  @Override
  @Bean
  protected UserDetailsService userDetailsService() {
    return new InMemoryUserDetailsManager(
      User.builder()
        .username("admin")
        .password(passwordEncoder().encode("admin"))
        .roles("ADMIN")
        .build()
    );
  }

  @Bean
  protected PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }
}
