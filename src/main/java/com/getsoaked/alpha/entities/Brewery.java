package com.getsoaked.alpha.entities;

import com.getsoaked.alpha.payloads.BreweryReq;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    // Because the controller will always return beers along with the brewery, LAZY would be meaningless.
    @OneToMany(mappedBy = "brewery", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Beer> beers = new HashSet<>();

    @Builder
    public Brewery(String name, double x, double y, String address, String phone) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.address = address;
        this.phone = phone;
    }

    public void updateBrewery(BreweryReq req) {
        this.name = req.getName();
        this.x = req.getX();
        this.y = req.getY();
        this.address = req.getAddress();
        this.phone = req.getPhone();
    }
}
