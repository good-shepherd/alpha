package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.Place;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceRes {
    private Long id;
    private String name;
    private int type;
    private double x;
    private double y;
    private String address;
    private String phone;

    public PlaceRes(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.type = place.getType().getValue();
        this.x = place.getX();
        this.y = place.getY();
        this.address = place.getAddress();
        this.phone = place.getPhone();
    }
}
