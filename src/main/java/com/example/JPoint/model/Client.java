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
//import java.time.LocalDateTime;
//import java.util.List;
//@Entity
//@Getter
//@Setter
//@ToString
//@Table(name = "client")
//public class Client {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "name")
//    private String name;
//    @CreationTimestamp
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    private LocalDateTime creation;
//
//    @UpdateTimestamp
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    private LocalDateTime update;
//    @ManyToOne
//    @ToString.Exclude
//    @JoinColumn(name = "client_id", referencedColumnName = "id")
//    private User users;
//
////    @Enumerated(value = EnumType.STRING)
////    @Column(name = "status")
////    private List<Departament>departaments;
////
////    @Enumerated(value = EnumType.STRING)
////    @Column(name = "status")
////    private List<Post>posts;
//}
