package fr.formation.hol.spring.sec.services;

import fr.formation.hol.spring.sec.dtos.UserAccountCreateDto;

public interface UserAccountService {

    void create(UserAccountCreateDto dto);

    void deleteById(Long id);
}
