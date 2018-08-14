package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.MenuStatus;
import com.getsoaked.alpha.entities.ServiceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// MenuStatus payload
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

    public BeerPackaging(MenuStatus menuStatus) {
        this.type = menuStatus.getServiceType();
        this.ml = menuStatus.getMl();
        this.price = menuStatus.getPrice();
    }
}
