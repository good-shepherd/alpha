package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.Brewery;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BreweryReq {

    private String name;
    private double x;
    private double y;
    private String address;
    private String phone;

    public Brewery toEntity() {
        return Brewery.builder()
                .address(this.address)
                .name(this.name)
                .x(this.x)
                .y(this.y)
                .phone(this.phone)
                .build();
    }
}
