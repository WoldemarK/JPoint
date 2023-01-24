package com.example.JPoint.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString

@Table(name = "company")
public class Company {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "company_type")
    @OneToMany(mappedBy = "company")
    private List<TypeCompany> typeCompanies;

    public void addTypeCompany(TypeCompany typeCompany) {
        if (typeCompanies == null) {
            typeCompanies = new ArrayList<>();
        }
        typeCompanies.add(typeCompany);
        typeCompany.setCompany(this);
    }

    @Column(name = "website")
    private String website;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "independent_search")
    private boolean independentSearch;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User users;

    @CreationTimestamp
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime creation;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime update;

    public Company(String name, String description, TypeCompany typeCompanies,
                   String website, String address, String phoneNumber, String email,
                   User users, LocalDateTime creation, LocalDateTime update) {
        this.name = name;
        this.description = description;
        this.typeCompanies = new ArrayList<>();
        this.website = website;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.independentSearch = true;
        this.users = users;
        this.creation = creation;
        this.update = update;
    }

    public Company() {
    }
}