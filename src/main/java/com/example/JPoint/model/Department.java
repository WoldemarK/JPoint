package com.example.JPoint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @NotBlank
    @Column(name = "description")
    private String description;

    @Column(name = "people_count")
    private Long peopleCount;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "person", referencedColumnName = "id")
    private Person person;


}
