package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.Beer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeerRes {
    private Long id;
    private String name;
    private float abv;
    private int type;
    private String description;
    private String brewery;

    public BeerRes(Beer beer) {
        this.id = beer.getId();
        this.name = beer.getName();
        this.abv = beer.getAbv();
        this.type = beer.getType();
        this.description = beer.getDescription();
        this.brewery = beer.getBrewery().getName();
    }
}
