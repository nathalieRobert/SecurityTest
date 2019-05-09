package fr.formation.hol.spring.sec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.hol.spring.sec.entities.UserAccount;


public interface UserAccountJpaRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByUsername(String username);
}
