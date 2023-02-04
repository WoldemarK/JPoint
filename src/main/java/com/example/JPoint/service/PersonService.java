package com.example.JPoint.service;

import com.example.JPoint.exception.AllException;
import com.example.JPoint.model.Person;
import com.example.JPoint.repository.DepartmentRepository;
import com.example.JPoint.repository.PersonRepository;
import com.example.JPoint.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final DepartmentRepository departmentRepository;
    private final PostRepository postRepository;

    @Transactional
    public Person createNewPerson(@Validated Person _person, Long personId) {
        return personRepository.save(_person);

    }
    @Transactional
    public Person createPersonAndDepartmentAndPost(@Validated Person _person,
                                                   Long departmentId,
                                                   Long postId) {
        _person.addDepartment(departmentRepository.findById(departmentId).get());
        _person.addPost(postRepository.findById(postId).get());
        return personRepository.save(_person);
    }

    public Person getPersonsById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new AllException("Пользователя с " + id + " не существует"));

    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();

    }

    @Transactional
    public void update(@Validated Person person, Long id) {
        Person per = getPersonsById(id);
        per.setLogin(person.getLogin());
        per.setPassword(person.getPassword());
        per.setFirstName(person.getFirstName());
        per.setLastName(person.getLastName());
        per.setBirth(person.getBirth());
        per.setPhoneNumber(person.getPhoneNumber());
        per.setEmail(person.getEmail());
        per.setCreation(person.getCreation());
        per.setUpdate(person.getUpdate());
        per.setDepartments(person.getDepartments());
        per.setPosts(person.getPosts());
        personRepository.save(per);


    }

    @Transactional
    public void delete(@Validated Long id) {
        Optional<Person> user = personRepository.findById(id);
        if (user.isPresent()) {
            personRepository.deleteById(id);
        }
        throw new AllException("Пользователя с " + id + " не существует");
    }

    public List<Person> getNames(String _nameF, String _nameL) {
        return personRepository.findByFirstNameOrLastName(_nameF, _nameL);
    }

    public List<Person> startStartingWithNames(String _name) {
        return personRepository.findByFirstNameIsStartingWith(_name);
    }

}
