package com.example.JPoint.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "type_company")
@RequiredArgsConstructor
public class TypeCompany {
    private static final String PROJECT_ORGANIZATION = "PROJECT_ORGANIZATION";
    private static final String MEDICAL = "MEDICAL";
    private static final String RESELLERS = "RESELLERS";
    private static final String SUPPLIERS = "SUPPLIERS";
    private static final String INDUSTRY = "INDUSTRY";
    private static final String STATE = "STATE";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "custom")
    private boolean custom;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id")
    private Company company;
}
