package com.macoyshev.restAPI.security.jwt;

import com.macoyshev.restAPI.security.services.MyUserDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.net.Authenticator;

public class JwtUtil {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

  private String jwtSecret;

  private int jwtExpirationMs;

  public String generateJwtToken(Authenticator authenticator) {
    return null;
  }

  public String getUsernameFromJwtToken(String token) {
    return null;
  }

  public boolean validateToken(String authToken) {
    return false;
  }
}
