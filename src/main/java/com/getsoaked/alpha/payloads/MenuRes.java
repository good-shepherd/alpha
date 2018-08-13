package com.getsoaked.alpha.payloads;

import com.getsoaked.alpha.entities.BeerMenu;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MenuRes {
    private BeerRes beer;
    private List<BeerPackaging> packaging;

    public MenuRes(BeerMenu beerMenu, ) {
        this.beer = new BeerRes(beerMenu.getBeer());
        this.draftPPM = beerMenu.getMenuStatuses();
        this.canPPM = beerMenu.getCanPPM();
        this.bottlePPM = beerMenu.getBottlePPM();
        this.status = beerMenu.getStatus().getValue();
    }
}
