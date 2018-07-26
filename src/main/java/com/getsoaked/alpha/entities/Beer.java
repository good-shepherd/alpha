package com.getsoaked.alpha.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "beers")
public class Beer extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "beer_id")
    private Long id;

    @Column(name = "beer_name")
    private String name;

    @Column(name = "beer_abv")
    private float abv;

    @Column(name = "beer_type")
    private BeerType type;

    @Column(name = "beer_description")
    private String description;

    @OneToMany(mappedBy = "beer")
    private Set<BeerMenu> beerMenus = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;

    @Builder
    public Beer(String name, float abv, BeerType type, String description, Brewery brewery) {
        this.name = name;
        this.abv = abv;
        this.type = type;
        this.description = description;
        this.brewery = brewery;
    }
}
