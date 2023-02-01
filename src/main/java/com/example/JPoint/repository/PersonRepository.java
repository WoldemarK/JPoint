package com.example.JPoint.repository;
import com.example.JPoint.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByFirstNameOrLastName(String _nameF, String _nameL);

    List<Person> findByFirstNameIsStartingWith(String name);

//    List<Person> findByActive(boolean _isActive);
//
//    List<Person> findByDepartmentContaining(String _department);
}
