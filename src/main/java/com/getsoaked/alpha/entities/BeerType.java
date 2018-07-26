package com.getsoaked.alpha.entities;

import lombok.Getter;

@Getter
public enum BeerType {
    LAGER(0), ALE(1), PALE_ALE(2), IPA(3), DOUBLE_IPA(4), SAISON(5), SESSION_IPA(6), BLANC(7), STOUT(8), SOUR_ALE(9);

    private int value;

    BeerType(int value) {
        this.value = value;
    }
}
