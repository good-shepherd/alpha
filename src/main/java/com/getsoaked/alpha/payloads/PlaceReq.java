package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.Place;
import com.getsoaked.alpha.entities.PlaceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceReq {

    private String name;
    private PlaceType type;
    private double x;
    private double y;
    private String address;
    private String phone;

    public Place toEntity() {
        return Place.builder()
                .address(this.address)
                .name(this.name)
                .phone(this.phone)
                .x(this.x)
                .y(this.y)
                .type(this.type)
                .build();
    }
}
