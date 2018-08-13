package com.getsoaked.alpha.entities;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "beermenus")
public class BeerMenu {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "beerId", column = @Column(name = "beer_id")),
            @AttributeOverride(name = "placeId", column = @Column(name = "place_id"))})
    private CompositePK id;

    @ManyToOne
    @JoinColumn(name = "beer_id", insertable = false, updatable = false)
    private Beer beer;

    @ManyToOne
    @JoinColumn(name = "place_id", insertable = false, updatable = false)
    private Place place;

    @OneToMany(mappedBy = "beerMenu", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<MenuStatus> menuStatuses = new HashSet<>();

    @Builder
    public BeerMenu(CompositePK id, Beer beer, Place place, Set<MenuStatus> menuStatuses) {
        this.id = id;
        this.beer = beer;
        this.place = place;
        this.menuStatuses = menuStatuses;
    }
}
