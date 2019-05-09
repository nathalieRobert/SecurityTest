package fr.formation.hol.spring.sec.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {

    private static final Logger LOGGER = LoggerFactory
	    .getLogger(SecurityController.class);

    protected SecurityController() {
	// Default no-arg constructor
    }

    @GetMapping("/me")
    protected User me() {
	return (User) SecurityContextHolder.getContext().getAuthentication()
		.getPrincipal();
    }

    @RequestMapping("/authError")
    protected ResponseEntity<Object> authError() {
	return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping("/logout")
    protected ResponseEntity<Object> logout() {
	System.out.println("### BAD SYSOUT PRACTICE!!! ###");
	return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/login")
    protected ResponseEntity<Object> login() {
	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
