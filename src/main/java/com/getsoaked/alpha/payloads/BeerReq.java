package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.Beer;
import com.getsoaked.alpha.entities.Brewery;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BeerReq {

    private String name;
    private float abv;
    private int type;
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
