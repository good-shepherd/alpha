package com.getsoaked.alpha.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class CompositePK implements Serializable {
    private Long beerId;
    private Long placeId;

    @Builder
    public CompositePK(Long beerId, Long placeId) {
        this.beerId = beerId;
        this.placeId = placeId;
    }
}
