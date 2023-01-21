package com.example.JPoint.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "year_of_birth")
    private String birth;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Email
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Column(name = "post")
    @Enumerated(value = EnumType.STRING)
    private Post post;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status_role")
    private StatusRole statusRole;
    @Column(name = "departament")
    @Enumerated(value = EnumType.STRING)
    private Departament departament;
    @CreationTimestamp
    @Column(name = "creation")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime creation;
    @UpdateTimestamp
    @Column(name = "update")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime update;


    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber,
                String email, Role role, Post post, StatusRole statusRole,
                Departament departament) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.post = post;
        this.statusRole = statusRole;
        this.departament = departament;
        this.creation = LocalDateTime.now();
        this.update = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", year_of_birth='" + birth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", post=" + post +
                ", statusRole=" + statusRole +
                ", departament=" + departament +
                ", creation=" + creation +
                ", update=" + update +
                '}';
    }
}
