package com.example.JPoint.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "post")
public class Post {
    private static final String DIRECTOR = "DIRECTOR";
    private static final String MANAGER = "MANAGER";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "custom")
    private boolean isCustom;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    public Post(String name, String description, boolean isCustom) {
        this.name = name;
        this.description = description;
        this.isCustom = isCustom;
    }

    public Post() {
    }
}
