package com.souza.people.services;

import com.souza.people.dto.request.PersonRequestDTO;
import com.souza.people.dto.response.PersonReponseDTO;
import com.souza.people.entity.Person;
import com.souza.people.repository.PeopleRepository;
import com.souza.people.util.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonServices {


    private final PeopleRepository peopleRepository;

    private final PersonMapper personMapper;

    @Override
    public PersonReponseDTO findById(long id) {
        return personMapper.toPersonDto(returnPerson(id));
    }

    @Override
    public List<PersonReponseDTO> findAll() {
        return personMapper.toPeopleDTO(peopleRepository.findAll());
    }

    @Override
    public PersonReponseDTO register(PersonRequestDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);

        return personMapper.toPersonDto(peopleRepository.save(person));
    }

    @Override
    public PersonReponseDTO update(Long id,PersonRequestDTO personDTO) {

        Person person = returnPerson(id);

        personMapper.updatePersonData(person, personDTO);


        return  personMapper.toPersonDto(peopleRepository.save(person));


    }

    @Override
    public String delete(Long id) {
        peopleRepository.deleteById(id);

        return "Pessoa id>: " + id + " deletado✅";
    }

    private Person returnPerson(Long id){
        return peopleRepository.findById(id).orElseThrow(() -> new RuntimeException("Não foi possivel encontrar esse id no Mysql"));
    }
}
