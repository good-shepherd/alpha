package com.getsoaked.alpha.payloads;

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
}
