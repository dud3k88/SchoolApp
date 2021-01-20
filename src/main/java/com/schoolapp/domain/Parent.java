package com.schoolapp.domain;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "parents")
@EqualsAndHashCode
@ToString
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    private String firstName;
    private String secondName;
    private String emailAddress;

    public Parent(String firstName, String secondName, String emailAddress) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.emailAddress = emailAddress;
    }
}
