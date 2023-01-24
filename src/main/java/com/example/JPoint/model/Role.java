package com.example.JPoint.model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "role")
public class Role { //implements GrantedAuthority
    private static final String ADMIN = "ADMIN";
    private static final String EMPLOYEE = "EMPLOYEE";
    private static final String CLIENT = "CLIENT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "custom")
    private boolean isCustom;

    @Column(name = "isACTIVE")
    private boolean isACTIVE;

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
        this.isCustom = true;
        this.isACTIVE = true;
    }


//    @Override
//    public String getAuthority() {
//        return String.format("ROLE_%s", name);
//    }
}
