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
@Table(name = "LOCALIZATIONS")
public class Localization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "LOCALIZATION_ID")
    private Long id;

    @Column(name = "LOCALIZATION_NAME")
    private String localizationName;

    @OneToMany(
            targetEntity = Group.class,
            mappedBy = "localization",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE},
            fetch = FetchType.EAGER
    )
    private List<Group> groups = new ArrayList<>();

    public Localization(String localizationName) {
        this.localizationName = localizationName;
    }
}

