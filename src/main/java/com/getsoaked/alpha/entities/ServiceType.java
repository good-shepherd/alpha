package com.getsoaked.alpha.entities;

import lombok.Getter;

@Getter
public enum ServiceType {

    TAP(0), CAN(1), BOTTLE(2);

    private int value;

    ServiceType(int value) {
        this.value = value;
    }
}
