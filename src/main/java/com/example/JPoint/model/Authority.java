package com.example.JPoint.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authority")
public class Authority {
    @Id
    @Column(name = "id")
    private short id;

    @Column(name = "authority")
    private String authority;

    @OneToMany(mappedBy = "authority")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private List<User> user;
}
