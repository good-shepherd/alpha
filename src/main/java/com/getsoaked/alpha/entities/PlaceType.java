package com.getsoaked.alpha.entities;

import lombok.Getter;

@Getter
public enum PlaceType {
    PUB(0), TASTING_ROOM(1), BAR(2), RESTAURANT(3), MART(4);

    private int value;

    PlaceType(int value) {
        this.value = value;
    }
}
