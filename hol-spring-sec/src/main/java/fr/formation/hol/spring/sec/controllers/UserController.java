package fr.formation.hol.spring.sec.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.hol.spring.sec.dtos.UserAccountCreateDto;
import fr.formation.hol.spring.sec.entities.UserAccount;
import fr.formation.hol.spring.sec.services.UserAccountService;

@RestController
@RequestMapping("/users")
public class UserController {

    UserAccountService service;

    public UserController(UserAccountService service) {
	super();
	this.service = service;
    }

    @PostMapping
    protected void createUserAccount(@RequestBody UserAccountCreateDto dto) {
	service.create(dto);
    }

    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    protected void deleteUserAccount(@PathVariable("id") Long id) {
	service.deleteById(id);
    }
}
