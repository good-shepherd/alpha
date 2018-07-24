package com.getsoaked.alpha.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "foods")
public class Food extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "food_id")
    private Long id;

    @Column(name = "food_name")
    private String name;

    @Column(name = "food_description")
    private String description;

    @Builder
    public Food(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
