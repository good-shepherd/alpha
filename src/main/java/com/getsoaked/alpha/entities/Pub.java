package com.getsoaked.alpha.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "pubs")
public class Pub extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pub_id")
    private Long id;

    @Column(name = "pub_name")
    private String name;

    @Column(name = "pub_type")
    private int type;

    @Column(name = "pub_location_x")
    private double x;

    @Column(name = "pub_location_y")
    private double y;

    @Column(name = "pub_address")
    private String address;

    @Column(name = "pub_phone")
    private int phone;

    @OneToMany(mappedBy = "pub")
    private Set<BeerMenu> beerMenus = new HashSet<>();

    @Builder
    public Pub(String name, int type, double x, double y, String address, int phone) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
        this.address = address;
        this.phone = phone;
    }
}
