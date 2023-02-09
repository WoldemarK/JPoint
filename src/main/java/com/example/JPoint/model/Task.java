package com.example.JPoint.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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


    @Column(name = "title", length = 128, nullable = false)
    private String title;
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
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<Company> company;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "task_user",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

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
    public void addUser(User _user) {
        if (this.users == null)
            this.users = new ArrayList<>();
        this.users.add(_user);
   //  _user.getTasks().add(this);

    }
    public void removePerson(User _user){
        this.users.remove(_user);

    }
}
