package com.getsoaked.alpha.entities;

import lombok.Getter;

@Getter
public enum PlaceType {
    PUB(0), BAR(1), RESTAURANT(2);

    private int value;

    PlaceType(int value) {
        this.value = value;
    }
}
