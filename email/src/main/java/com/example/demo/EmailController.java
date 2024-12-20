package com.example.demo;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Class
public class EmailController {

	@Autowired private EmailService emailService;
	@Autowired EmailServiceImpl e;

	@PostMapping("/sendMail")
	public String
	sendMail(@RequestBody Email details)
	{
		String status
			= emailService.sendSimpleMail(details);

		return status;
	}

	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(
		@RequestBody Email details)
	{
		String status
			= emailService.sendMailWithAttachment(details);
		return status;
	}
	
    @GetMapping("/emails")
    public List<String> getEmailSubjects() throws MessagingException {
        return e.readEmails();
    }
}
