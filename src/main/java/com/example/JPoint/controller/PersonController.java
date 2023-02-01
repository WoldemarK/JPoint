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

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPerson() {
        List<Person> people = personService.getAllPersons();
        if (people.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PostMapping("/create/{depId}/dep")
    public ResponseEntity<Person> createPersonAndDepartment(@RequestBody Person _person, @PathVariable("depId") Long depId) {
        return _person == null
                ? new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED)
                : new ResponseEntity<>(personService.createNewPersonsAndDepartment(_person, depId), HttpStatus.CREATED);

    }

    @PostMapping("/create/{depId}/{postId}")
    public ResponseEntity<Person> createPersonAndDepartmentAndPost(@RequestBody Person _person,
                                                                   @PathVariable("depId") Long depId,
                                                                   @PathVariable("postId") Long postId) {
        return _person == null
                ? new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED)
                : new ResponseEntity<>(personService.createPersonAndDepartmentAndPost(_person, depId, postId), HttpStatus.CREATED);

    }

    @PostMapping("/create/{postId}/post")
    public ResponseEntity<Person> createPersonAndPost(@RequestBody Person _person, @PathVariable("postId") Long posrId) {
        return _person == null
                ? new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED)
                : new ResponseEntity<>(personService.createPersonAndPost(_person, posrId), HttpStatus.CREATED);

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
