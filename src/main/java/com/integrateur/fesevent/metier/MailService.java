package com.integrateur.fesevent.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.integrateur.fesevent.Exception.SpringRedditException;
import com.integrateur.fesevent.modules.Notification;



@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Mailbuilder mailbuilder;
	
	public MailService() {
		// TODO Auto-generated constructor stub
	}

	@Async
	public void sendEmail(Notification notification) {
		 MimeMessagePreparator messagePreparator = mimeMessage -> {
	            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
	            messageHelper.setFrom("springreddit@email.com");
	            messageHelper.setTo(notification.getRecipient());
	            messageHelper.setSubject(notification.getSubject());
	            messageHelper.setText(notification.getBody());
	        };
	        try {
	            mailSender.send(messagePreparator);
	        } catch (MailException e) {
	            throw new SpringRedditException("Exception occurred when sending mail to " + notification.getRecipient(), e);
	        }
	}
	
}
