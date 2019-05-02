package fr.formation.hol.spring.sec.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    protected UserController() {
	// Default no-arg constructor
    }
}
