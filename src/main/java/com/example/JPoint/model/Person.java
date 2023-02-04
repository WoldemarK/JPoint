package com.example.JPoint.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "First Name should be between 2 and 20 characters")
    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @NotEmpty(message = "Last Name should not be empty")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters")
    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @Column(name = "year_of_birth")
    private String birth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Email
    @Column(name = "email")
    private String email;
    @JsonProperty
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "sex")
    private String sex;
    @CreationTimestamp
    @Column(name = "creation")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate creation;

    @UpdateTimestamp
    @Column(name = "update")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate update;

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Department> departments;
    @ManyToMany(mappedBy = "people")
    private List<Task> tasks;
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Post> posts;

    public void addDepartment(Department _department) {
        if (this.departments == null)
            this.departments = new ArrayList<>();
        this.departments.add(_department);
        _department.setPerson(this);
    }

    public void addPost(Post _post) {
        if (this.posts == null)
            this.posts = new ArrayList<>();
        this.posts.add(_post);
        _post.setPerson(this);
    }

    public void addTask(Task _task) {
        if (this.tasks == null)
            this.tasks = new ArrayList<>();
        this.tasks.add(_task);
        _task.getPeople().remove(this);
    }
}
