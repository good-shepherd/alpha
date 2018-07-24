package com.getsoaked.alpha.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeerReq {
    private String name;
    private float abv;
    private int type;
    private String description;
    private long breweryId;
    // validation needed
}
