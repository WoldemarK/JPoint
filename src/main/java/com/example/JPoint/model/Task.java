package com.example.JPoint.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@ToString
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String descriptions;
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
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

}
