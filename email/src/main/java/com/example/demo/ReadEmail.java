package com.example.demo;

import java.io.IOException;
import java.util.Properties;

import jakarta.mail.MessagingException;

public interface ReadEmail {

    String USERNAME = null;
	String PASSWORD = null;

	void process(String protocol, String host, Properties props) throws MessagingException, IOException, javax.mail.MessagingException;

}
