package com.schoolapp.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "GROUPS")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "GROUP_ID")
    private Long groupId;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "MIN_SIZE")
    private int minYearOfBirth;

    @Column(name = "MAX_SIZE")
    private int maxYearOfBirth;

    @ManyToMany(cascade =
            {
            CascadeType.PERSIST,
            CascadeType.DETACH
            })
    @JoinTable(
            name = "children_group",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns =  @JoinColumn(name = "group_id")
    )
    private List<Child> children = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "LOCALIZATION_GROUP")
    private Localization localization;

    public Group(String groupName, int minYearOfBirth, int maxYearOfBirth) {
        this.groupName = groupName;
        this.minYearOfBirth = minYearOfBirth;
        this.maxYearOfBirth = maxYearOfBirth;
    }

    public void addChildren(Child child) {
        if (child.getYearOfBirth() < maxYearOfBirth && child.getYearOfBirth() > minYearOfBirth) {
            children.add(child);
        } else {
            System.out.println("incorrect Age");
        }
    }
}
