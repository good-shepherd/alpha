package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.ServiceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeerPackaging {
    private ServiceType type;
    private int ml;
    private int price;

    @Builder
    public BeerPackaging(ServiceType type, int ml, int price) {
        this.type = type;
        this.ml = ml;
        this.price = price;
    }
}
