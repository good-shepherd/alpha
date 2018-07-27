package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuReq {
    private Long beerId;
    private Long placeId;
    private float draftPPM;
    private float canPPM;
    private float bottlePPM;
    private StatusType status;

    public BeerMenu toEntity(Place place, Beer beer) {
        return BeerMenu.builder()
                .bottlePPM(this.bottlePPM)
                .canPPM(this.canPPM)
                .draftPPM(this.draftPPM)
                .status(this.status)
                .id(CompositePK.builder().beerId(this.beerId).placeId(this.placeId).build())
                .beer(beer)
                .place(place)
                .build();
    }
}
