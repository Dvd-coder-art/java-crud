package com.souza.people.controller;

import com.souza.people.dto.request.PersonRequestDTO;
import com.souza.people.dto.response.PersonReponseDTO;
import com.souza.people.services.PersonServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/{people}")
@RequiredArgsConstructor
public class PersonalController {

    private final PersonServices personServices;

    @GetMapping("/{id}")
    public ResponseEntity<PersonReponseDTO> findByid(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(personServices.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonReponseDTO>> findAll(){
        return ResponseEntity.ok().body(personServices.findAll());
    }

    @PostMapping
    public ResponseEntity<PersonReponseDTO> register(@RequestBody PersonRequestDTO personRequestDTO, UriComponentsBuilder uriBuilder){

        PersonReponseDTO personReponseDTO = personServices.register(personRequestDTO);

        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(personReponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(personReponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonReponseDTO> update(@RequestBody PersonRequestDTO personRequestDTO,@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(personServices.update(id, personRequestDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(personServices.delete(id));
    }
}
