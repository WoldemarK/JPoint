package com.example.JPoint.controller;

import com.example.JPoint.model.Person;
import com.example.JPoint.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService personService;

    @GetMapping("/get/all")
    public ResponseEntity<List<Person>> getAllPerson() {
        List<Person> people = personService.getAllPersons();
        if (people.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PostMapping("/create/{_depId}/{_postId}")
    public ResponseEntity<Person> createPersonAndDepartmentAndPost(@RequestBody Person _person,
                                                                   @PathVariable("_depId") Long _depId,
                                                                   @PathVariable("_postId") Long _postId) {
        return _person == null
                ? new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED)
                : new ResponseEntity<>(personService.createPersonAndDepartmentAndPost(_person, _depId, _postId),
                HttpStatus.CREATED);
    }

    @PostMapping("/create/{personId}/person")
    public ResponseEntity<Person> createNewPerson(@RequestBody Person _person, @PathVariable("personId") Long personId) {
        return _person == null
                ? new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED)
                : new ResponseEntity<>(personService.createNewPerson(_person, personId), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") Long id) {
        return personService.getPersonsById(id);
    }
}
