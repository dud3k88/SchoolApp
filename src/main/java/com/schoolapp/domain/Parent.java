package com.schoolapp.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PARENTS")
@EqualsAndHashCode
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "PARENT_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "SECONDNAME")
    private String secondName;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @OneToMany(
            targetEntity = Child.class,
            mappedBy = "parent",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Child> children = new ArrayList<>();

    public Parent(String name, String firstName, String secondName, String emailAddress) {
        this.name = name;
        this.firstName = firstName;
        this.secondName = secondName;
        this.emailAddress = emailAddress;
    }

    public void addChild(Child child) {
        children.add(child);
    }
}
