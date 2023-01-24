package com.example.JPoint.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "project_name")
    private String nameProject;
    @Column(name = "description")
    private String description;
    @CreationTimestamp
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime creation;
    @UpdateTimestamp
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime update;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company company;
}
