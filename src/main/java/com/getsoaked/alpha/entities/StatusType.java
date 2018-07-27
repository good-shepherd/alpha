package com.getsoaked.alpha.entities;

import lombok.Getter;

@Getter
public enum StatusType {
    AVAILABLE(0), SOLD_OUT(1);

    private int value;

    StatusType(int value) {
        this.value = value;
    }
}
