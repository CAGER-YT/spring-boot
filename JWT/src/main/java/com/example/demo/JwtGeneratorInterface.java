package com.example.demo;

import java.util.Map;

public interface JwtGeneratorInterface {
	Map<String, String> generateToken(User user);
}
