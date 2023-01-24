package com.example.JPoint.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
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

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns =
    @JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;
    @Column(name = "is_project")
    private boolean isProject;
    @Column(name = "is_task")
    private boolean isTask;

    @CreationTimestamp
    @Column(name = "creation")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime creation;
    @UpdateTimestamp
    @Column(name = "update")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime update;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Department> departments;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Post> posts;

    public void addRol(Role role) {
        if (roles == null) {
            roles = new ArrayList<>();
        }
        roles.add(role);

    }

    public void addDepartment(Department department) {
        if (departments == null) {
            departments = new ArrayList<>();
        }
        departments.add(department);
        department.setUser(this);
    }

    public void addPost(Post post) {
        if (posts == null) {
            posts = new ArrayList<>();
        }
        posts.add(post);
        post.setUser(this);
    }

    public User() {
    }

    //    @Override
//    @JsonIgnore
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return getRoles();
//    }
//
//    @Override
//    public String getUsername() {
//        return login;
//    }
//
//    @Override
//    @JsonIgnore
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    @JsonIgnore
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    @JsonIgnore
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    @JsonIgnore
//    public boolean isEnabled() {
//        return true;
//    }

}
