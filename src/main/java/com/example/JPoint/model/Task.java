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

    @NotEmpty(message = "Name should not be empty")
    @Column(name = "name", length = 128, nullable = false)
    @Size(min = 2, max = 128, message = "Name should be between 2 and 30 characters")
    private String name;
    @Column(name = "descriptions", length = 5000, nullable = false)
    private String descriptions;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "task_company",
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"))
    private List<Company> companies;
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
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "person", referencedColumnName = "id")
    private Person person;

    public void addCompany(Company _company) {
        if (this.companies == null)
            this.companies = new ArrayList<>();
        this.companies.add(_company);
        _company.getTasks().add(this);
    }

    public void removeCompany(Company _company) {
        this.companies.remove(_company);
        _company.getTasks().remove(this);
    }
}
