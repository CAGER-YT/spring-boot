package com.example.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtGeneratorImpl implements JwtGeneratorInterface{

  @Value("${jwt.secret}")
  private String secret;

  @Value("${app.jwttoken.message}")
  private String message;

  @Override
  public Map<String, String> generateToken(User user) {
    String jwtToken="";
    jwtToken = Jwts.builder().setSubject(user.getUserName())
    		.setIssuedAt(new Date())
    		.signWith(SignatureAlgorithm.HS256, "secret")
    		.compact();
    Map<String, String> jwtTokenGen = new HashMap<>();
    jwtTokenGen.put("token", jwtToken);
    jwtTokenGen.put("message", message);
    return jwtTokenGen;
  }
}