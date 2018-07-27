package com.getsoaked.alpha.entities;

import com.getsoaked.alpha.payloads.PlaceReq;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "places")
public class Place extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "place_id")
    private Long id;

    @Column(name = "place_name")
    private String name;

    @Column(name = "place_type")
    private PlaceType type;

    @Column(name = "place_location_x")
    private double x;

    @Column(name = "place_location_y")
    private double y;

    @Column(name = "place_address")
    private String address;

    @Column(name = "place_phone")
    private String phone;

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<BeerMenu> beerMenus = new HashSet<>();

    @Builder
    public Place(String name, PlaceType type, double x, double y, String address, String phone) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
        this.address = address;
        this.phone = phone;
    }

    public void updatePlace(PlaceReq req) {
        this.name = req.getName();
        this.type = req.getType();
        this.x = req.getX();
        this.y = req.getY();
        this.address = req.getAddress();
        this.phone = req.getPhone();
    }
}
