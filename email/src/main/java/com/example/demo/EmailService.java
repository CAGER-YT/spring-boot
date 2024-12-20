package com.example.demo;

public interface EmailService {

	String sendSimpleMail(Email details);

	String sendMailWithAttachment(Email details);
}
