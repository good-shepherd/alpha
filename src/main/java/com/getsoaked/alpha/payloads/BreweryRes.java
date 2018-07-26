package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.Brewery;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BreweryRes {

    private Long id;
    private String name;
    private double x;
    private double y;
    private String address;
    private String phone;
    private List<BeerRes> beers;

    public BreweryRes(Brewery brewery) {
        this.id = brewery.getId();
        this.name = brewery.getName();
        this.x = brewery.getX();
        this.y = brewery.getY();
        this.address = brewery.getAddress();
        this.phone = brewery.getPhone();
        this.beers = brewery.getBeers().stream().map(BeerRes::new).collect(Collectors.toList());
    }
}
