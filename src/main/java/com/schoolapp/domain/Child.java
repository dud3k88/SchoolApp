package com.schoolapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CHILDREN")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "CHILD_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @Column(name = "YEAR_OF_BIRTH")
    private int yearOfBirth;

    @ManyToOne
    @JoinColumn(name = "PARENT_CHILDREN")
    private Parent parent;

    private Long parentId;

   @ManyToMany(mappedBy = "children",
   cascade = {
           CascadeType.PERSIST,
           CascadeType.DETACH
   })
    private List<Group> childrenGroups;

    public Child(String firstName, String secondName, int yearOfBirth) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.yearOfBirth = yearOfBirth;
    }
}
