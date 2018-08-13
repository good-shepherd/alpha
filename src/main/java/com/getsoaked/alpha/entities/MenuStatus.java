package com.getsoaked.alpha.entities;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "menustatuses")
public class MenuStatus extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menustatus_id")
    private Long id;

    private int ml;

    private ServiceType serviceType;

    private int price;

    @ManyToOne
    private BeerMenu beerMenu;

    @Builder
    public MenuStatus(int ml, ServiceType serviceType, int price, BeerMenu beerMenu) {
        this.ml = ml;
        this.serviceType = serviceType;
        this.price = price;
        this.beerMenu = beerMenu;
    }
}
