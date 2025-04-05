package com.souza.people.dto.response;


import com.souza.people.entity.Person;
import lombok.Getter;

@Getter
public class PersonReponseDTO {

    private Long id;


    private String name;


    private String cpf;


    private String age;

    public PersonReponseDTO(Person person){
        this.id = person.getId();
        this.name = person.getName();
        this.cpf = person.getCpf();
        this.age = person.getAge();
    }
}
