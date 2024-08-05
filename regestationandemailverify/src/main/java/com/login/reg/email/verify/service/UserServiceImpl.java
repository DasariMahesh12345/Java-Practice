package com.login.reg.email.verify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.login.reg.email.verify.entity.ConfirmationToken;
import com.login.reg.email.verify.entity.User;
import com.login.reg.email.verify.respository.ConfirmationTokenRepository;
import com.login.reg.email.verify.respository.UserRepository;
@Service
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class UserServiceImpl implements UserService {
	
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    ConfirmationTokenRepository confirmationTokenRepository;

	    @Autowired
	    EmailService emailService;
	  

	    @Override
	    public ResponseEntity<?> saveUser(User user) {

	        if (userRepository.existsByUserEmail(user.getUserEmail())) {
	            return ResponseEntity.badRequest().body("Error: Email is already in use!");
	        }

	        userRepository.save(user);

	        ConfirmationToken confirmationToken = new ConfirmationToken(user);

	        confirmationTokenRepository.save(confirmationToken);

	        SimpleMailMessage mailMessage = new SimpleMailMessage();
	        mailMessage.setTo(user.getUserEmail());
	        mailMessage.setSubject("Complete Registration!");
	        mailMessage.setText("To confirm your account, please click here : "
	                +"http://localhost:8081/confirm-account?token="+confirmationToken.getConfirmationToken());
	        emailService.sendEmail(mailMessage);

	        System.out.println("Confirmation Token: " + confirmationToken.getConfirmationToken());

	        return ResponseEntity.ok("Verify email by the link sent on your email address");
	    }

	    @Override
	    public ResponseEntity<?> confirmEmail(String confirmationToken) {
	        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

	        if(token != null)
	        {
	            User user = userRepository.findByUserEmailIgnoreCase(token.getUserEntity().getUserEmail());
	            user.setEnabled(true);
	            userRepository.save(user);
	            return ResponseEntity.ok("Email verified successfully!");
	        }
	        return ResponseEntity.badRequest().body("Error: Couldn't verify email");
	    }

}
