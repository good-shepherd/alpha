package com.getsoaked.alpha.entities;

import lombok.*;

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

    /*private float draftPPM;

    private float canPPM;

    private float bottlePPM;

    private StatusType status;

    @Builder
    public BeerMenu(CompositePK id, Beer beer, Place place, float draftPPM, float canPPM, float bottlePPM, StatusType status) {
        this.id = id;
        this.beer = beer;
        this.place = place;
        this.draftPPM = draftPPM;
        this.canPPM = canPPM;
        this.bottlePPM = bottlePPM;
        this.status = status;
    }*/
}
