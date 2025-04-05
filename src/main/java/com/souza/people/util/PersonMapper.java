package com.souza.people.util;

import com.souza.people.dto.request.PersonRequestDTO;
import com.souza.people.dto.response.PersonReponseDTO;
import com.souza.people.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PersonMapper {

    public Person toPerson(PersonRequestDTO personDTO){

        return Person.builder()
                .name(personDTO.getName())
                .cpf(personDTO.getCpf())
                .age(personDTO.getAge())
                .build();

    }

    public PersonReponseDTO toPersonDto(Person person){
        return new PersonReponseDTO(person);
    }

    public List<PersonReponseDTO> toPeopleDTO(List<Person> peopleList){
        return peopleList.stream().map(PersonReponseDTO::new).collect(Collectors.toList());
    }

    public void updatePersonData(Person person, PersonRequestDTO personDTO){
        person.setName(personDTO.getName());
        person.setCpf(personDTO.getCpf());
        person.setAge(personDTO.getAge());
    }
}
