package com.getsoaked.alpha.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "beermenus")
public class BeerMenu extends DateAudit {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "beerId", column = @Column(name = "beer_id")),
            @AttributeOverride(name = "pubId", column = @Column(name = "pub_id"))})
    private CompositePK id;

    @ManyToOne
    @JoinColumn(name = "beer_id", insertable = false, updatable = false)
    private Beer beer;

    @ManyToOne
    @JoinColumn(name = "pub_id", insertable = false, updatable = false)
    private Pub pub;

    private float draftPPM;

    private float canPPM;

    private float bottlePPM;

    private int status;

    @Builder
    public BeerMenu(CompositePK id, Beer beer, Pub pub, float draftPPM, float canPPM, float bottlePPM, int status) {
        this.id = id;
        this.beer = beer;
        this.pub = pub;
        this.draftPPM = draftPPM;
        this.canPPM = canPPM;
        this.bottlePPM = bottlePPM;
        this.status = status;
    }
}
