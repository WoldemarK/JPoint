package com.example.JPoint.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    @Column(name = "name", length = 128, nullable = false)
    @Size(min = 2, max = 128, message = "Name should be between 2 and 30 characters")
    private String name;
    @Column(name = "descriptions", length = 5000, nullable = false)
    private String descriptions;
    @CreationTimestamp
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate creation;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate update;


}
