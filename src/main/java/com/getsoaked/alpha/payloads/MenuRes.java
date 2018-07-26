package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.BeerMenu;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuRes {
    private BeerRes beer;
    private float draftPPM;
    private float canPPM;
    private float bottlePPM;
    private int status;

    public MenuRes(BeerMenu beerMenu) {
        this.beer = new BeerRes(beerMenu.getBeer());
        this.draftPPM = beerMenu.getDraftPPM();
        this.canPPM = beerMenu.getCanPPM();
        this.bottlePPM = beerMenu.getBottlePPM();
        this.status = beerMenu.getStatus();
    }
}
