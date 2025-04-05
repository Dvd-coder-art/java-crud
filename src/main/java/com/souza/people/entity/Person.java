package com.souza.people.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_people")
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name= "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name= "age", nullable = false)
    private String age;


    @Builder
    public Person(String age, String cpf, String name) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
    }
}
