package com.schoolapp.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    private String groupName;
    private int minYearOfBirth;
    private int maxYearOfBirth;
    @ManyToOne()
    @JoinColumn(name = "Localization_groups")
    private Localization localization;

    public Group(Long id, String groupName, int minYearOfBirth, int maxYearOfBirth, Localization localization) {
        this.id = id;
        this.groupName = groupName;
        this.minYearOfBirth = minYearOfBirth;
        this.maxYearOfBirth = maxYearOfBirth;
        this.localization = localization;
    }
}

