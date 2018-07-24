package com.getsoaked.alpha.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "breweries")
public class Brewery extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brewery_id")
    private Long id;

    @Column(name = "brewery_name")
    private String name;

    @Column(name = "brewery_location_x")
    private double x;

    @Column(name = "brewery_location_y")
    private double y;

    @Column(name = "brewery_address")
    private String address;

    @Column(name = "brewery_phone")
    private String phone;

    @OneToMany(mappedBy = "brewery")
    private Set<Beer> beers = new HashSet<>();

    @Builder
    public Brewery(String name, double x, double y, String address, String phone) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.address = address;
        this.phone = phone;
    }
}
