package com.example.JPoint.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "year_of_birth")
    private String birth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "is_active")
    @JsonProperty
    private boolean isActive;

    @CreationTimestamp
    @Column(name = "creation")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate creation;

    @UpdateTimestamp
    @Column(name = "update")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate update;

    @OneToMany
            (
                    mappedBy = "person",
                    cascade = CascadeType.PERSIST,
                    fetch = FetchType.LAZY
            )
    private List<Department> departments;
    @OneToMany
            (
                    mappedBy = "person",
                    cascade = CascadeType.PERSIST,
                    fetch = FetchType.LAZY
            )
    private List<Post> posts;
    public void addDepartment(Department department) {
        if (this.departments == null)
            this.departments = new ArrayList<>();
        this.departments.add(department);
        department.setPerson(this);
    }

    public void addPost(Post post) {
        if (this.posts == null)
            this.posts = new ArrayList<>();
        this.posts.add(post);
        post.setPerson(this);
    }

}
