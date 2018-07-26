package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.Beer;
import com.getsoaked.alpha.entities.BeerType;
import com.getsoaked.alpha.entities.Brewery;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeerReq {

    private String name;
    private float abv;
    private BeerType type;
    private String description;
    private long breweryId;

    public Beer toEntity(Brewery brewery) {
        return Beer.builder()
                .abv(this.abv)
                .type(this.type)
                .name(this.name)
                .description(this.description)
                .brewery(brewery)
                .build();
    }
    // validation needed
}
