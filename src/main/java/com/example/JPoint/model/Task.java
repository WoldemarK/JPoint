package com.example.JPoint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;
    @Column(name = "descriptions", length = 5000, nullable = false)
    private String descriptions;
    @CreationTimestamp
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate creation;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate update;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "task_company",
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"))
    private List<Company> company;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "task_person",
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"))
    private List<Person> people;

    public void addCompany(Company _company) {
        if (this.company == null)
            this.company = new ArrayList<>();
        this.company.add(_company);
        _company.getTasks().add(this);
    }

    public void removeCompany(Company _company) {
        this.company.remove(_company);
        _company.getTasks().remove(this);
    }
    public void addPerson(Person _person) {
        if (this.people == null)
            this.people = new ArrayList<>();
        this.people.add(_person);
        _person.getTasks().add(this);
    }
    public void removePerson(Person _person){
        this.people.remove(_person);

    }
}
