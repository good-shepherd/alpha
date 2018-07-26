package com.getsoaked.alpha.entities;

import lombok.Getter;

@Getter
public enum BeerType {
    LAGER(0), PALE_ALE(1), IPA(2), DOUBLE_IPA(3), SAISON(4);

    private int value;

    BeerType(int value) {
        this.value = value;
    }
}
