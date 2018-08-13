package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.ServiceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeerPackaging {
    private ServiceType type;
    private int ml;
    private int price;
}
