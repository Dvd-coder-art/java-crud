package com.souza.people.services;


import com.souza.people.dto.request.PersonRequestDTO;
import com.souza.people.dto.response.PersonReponseDTO;

import java.util.List;

public interface PersonServices {
    PersonReponseDTO findById(long id);

    List<PersonReponseDTO> findAll();

    PersonReponseDTO register(PersonRequestDTO personDTO);

    PersonReponseDTO update(Long id, PersonRequestDTO personDTO);


    String delete(Long id);
}
