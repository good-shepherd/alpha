package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MenuReq {
    private Long beerId;
    private Long placeId;
    private List<BeerPackaging> packaging;

    public BeerMenu toEntity(Place place, Beer beer) {
        return BeerMenu.builder()
                .id(CompositePK.builder().beerId(this.beerId).placeId(this.placeId).build())
                .beer(beer)
                .place(place)
                .build();
    }
}
