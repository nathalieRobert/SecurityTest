package fr.formation.hol.spring.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SpringBootApplication
public class HolSpringSecApplication {

    public static void main(String[] args) {
	SpringApplication.run(HolSpringSecApplication.class, args);
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }

    // La classe WebSecurityConfig sert à configurer la sécurité de
    // l'application
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
    protected class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
		throws Exception {
	    auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    // CSRF disabled to ease tests with Postman
	    http.csrf().disable().authorizeRequests()
		    .antMatchers("/login", "/security/authError",
			    "/security/login", "/security/logout", "/users")
		    .permitAll().and().formLogin().loginPage("/security/login")
		    .loginProcessingUrl("/login")
		    .defaultSuccessUrl("/security/me", true)
		    .failureUrl("/security/authError").and().logout()
		    .invalidateHttpSession(true)
		    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		    .logoutSuccessUrl("/security/logout").and()
		    .authorizeRequests().anyRequest().authenticated();
	}
    }
}
