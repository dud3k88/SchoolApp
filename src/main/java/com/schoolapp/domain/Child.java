package com.schoolapp.domain;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "children")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    private String firstName;
    private String secondName;
    private int yearOfBirth;
    @ManyToOne
    @JoinColumn(name = "parent_children")
    private Parent parent;
    @ManyToOne
    @JoinColumn(name = "child_group")
    private Group group;

    public Child(String firstName, String secondName, int yearOfBirth, Parent parent) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.yearOfBirth = yearOfBirth;
        this.parent = parent;
    }
}
