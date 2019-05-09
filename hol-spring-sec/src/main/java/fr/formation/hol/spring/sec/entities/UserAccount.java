package fr.formation.hol.spring.sec.entities;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class represents an User account.
 * 
 * @author Nathalie ROBERT
 */
@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    Role role = Role.ROLE_USER;

    @Column(nullable = false, length = 1)
    @Convert(converter = BooleanConverter.class)
    private boolean accountNonExpired = true;

    @Column(nullable = false, length = 1)
    @Convert(converter = BooleanConverter.class)
    private boolean accountNonLocked = true;

    @Column(nullable = false, length = 1)
    @Convert(converter = BooleanConverter.class)
    private boolean credentialsNonExpired = true;

    @Column(nullable = false, length = 1)
    @Convert(converter = BooleanConverter.class)
    private boolean enabled = true;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    public boolean isAccountNonExpired() {
	return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
	this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
	return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
	this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
	return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
	this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    public UserAccount() {
	super();
    }

    @Override
    public String toString() {
	return "UserAccount [id=" + id + ", username=" + username + ", role="
		+ role + ", accountNonExpired=" + accountNonExpired
		+ ", accountNonLocked=" + accountNonLocked
		+ ", credentialsNonExpired=" + credentialsNonExpired
		+ ", enabled=" + enabled + "]";
    }
}
