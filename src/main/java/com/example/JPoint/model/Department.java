package com.example.JPoint.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "department")
@RequiredArgsConstructor
public class Department {
    private static final String SALES =  "SALES";
    private static final String IT =  "IT";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @Column(name = "custom")
    private boolean custom;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

}
