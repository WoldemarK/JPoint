//package com.example.JPoint.model;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
//import java.time.LocalDateTime;
//@Entity
//@Getter
//@Setter
//@ToString
//@Table(name = "task")
//public class Task {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotEmpty(message = "Name should not be empty")
//    @Column(name = "name", length = 128, nullable = false)
//    @Size(min = 2, max = 128, message = "Name should be between 2 and 30 characters")
//    private String name;
//    @Column(name = "descriptions", length = 4068, nullable = false)
//    private String descriptions;
//    @CreationTimestamp
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    private LocalDateTime creation;
//
//    @UpdateTimestamp
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    private LocalDateTime update;
//    @Column(name = "executor")
//    private String executor;
//    @ManyToOne
//    @ToString.Exclude
//    @JoinColumn(name = "company_id", referencedColumnName = "id")
//    private Client client;
//
//    @ManyToOne
//    @ToString.Exclude
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;
//}
