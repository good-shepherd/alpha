package com.getsoaked.alpha.services;

import com.getsoaked.alpha.entities.BeerMenu;
import com.getsoaked.alpha.entities.CompositePK;
import com.getsoaked.alpha.entities.Place;
import com.getsoaked.alpha.payloads.MenuReq;
import com.getsoaked.alpha.payloads.MenuRes;
import com.getsoaked.alpha.payloads.PlaceReq;
import com.getsoaked.alpha.payloads.PlaceRes;
import com.getsoaked.alpha.repositories.BeerMenuRepository;
import com.getsoaked.alpha.repositories.BeerRepository;
import com.getsoaked.alpha.repositories.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlaceService {

    BeerMenuRepository beerMenuRepository;
    PlaceRepository placeRepository;
    BeerRepository beerRepository;

    // this returns all of the info of place except menus.
    @Transactional(readOnly = true)
    public List<PlaceRes> findAllPlaces() {
        return placeRepository.findAll().stream().map(PlaceRes::new).collect(Collectors.toList());
    } // pagination

    @Transactional(readOnly = true)
    public PlaceRes findOnePlace(Long id) {
        return new PlaceRes(placeRepository.getOne(id));
    }

    @Transactional
    public URI savePlace(PlaceReq req) {
        Place place = placeRepository.save(req.toEntity());
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/places/{id}")
                .buildAndExpand(place.getId()).toUri();
        return location;
    }

    @Transactional
    public void updatePlace(Long id, PlaceReq req) {
        Place place = placeRepository.getOne(id);
        place.updatePlace(req);
        placeRepository.save(place);
    }

    @Transactional
    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }


    // menus
    @Transactional(readOnly = true)
    public List<MenuRes> getMenuByPlaceId(Long id) {
        return beerMenuRepository.getAllByPlaceId(id).stream().map(MenuRes::new).collect(Collectors.toList());
    }

    @Transactional
    public URI saveMenuByPlaceId(Long id, MenuReq req) {
        BeerMenu menu = beerMenuRepository.save(req.toEntity(
                placeRepository.getOne(id),
                beerRepository.getOne(req.getBeerId())
        )); // three queries? really?
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/places/{id}/menu")
                .buildAndExpand(menu.getId().getPlaceId()).toUri();
        return location;
    }
    @Transactional
    public void deleteMenuById(Long id, Long bid) {
        beerMenuRepository.deleteById(CompositePK.builder()
                .placeId(id)
                .beerId(bid)
                .build());
    }
}
