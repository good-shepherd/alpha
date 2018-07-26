package com.getsoaked.alpha.controllers;

import com.getsoaked.alpha.entities.BeerMenu;
import com.getsoaked.alpha.entities.Place;
import com.getsoaked.alpha.payloads.MenuReq;
import com.getsoaked.alpha.payloads.MenuRes;
import com.getsoaked.alpha.payloads.PlaceReq;
import com.getsoaked.alpha.payloads.PlaceRes;
import com.getsoaked.alpha.repositories.BeerMenuRepository;
import com.getsoaked.alpha.repositories.BeerRepository;
import com.getsoaked.alpha.repositories.PlaceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/places")
public class PlaceController {

    BeerMenuRepository beerMenuRepository;
    PlaceRepository placeRepository;
    BeerRepository beerRepository;

    // this returns all of the info of place except menus.
    @Transactional(readOnly = true)
    @GetMapping
    public List<PlaceRes> findAllPlaces() {
        return placeRepository.findAll().stream().map(PlaceRes::new).collect(Collectors.toList());
    } // pagination

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public PlaceRes findOnePlace(@PathVariable(value = "id") Long id) {
        return new PlaceRes(placeRepository.getOne(id));
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}/menu")
    public List<MenuRes> getMenuByPlaceId(@PathVariable(value = "id") Long id) {
        return beerMenuRepository.getAllByPlaceId(id).stream().map(MenuRes::new).collect(Collectors.toList());
    }

    @Transactional
    @PostMapping("/{id}/menu")
    public ResponseEntity saveMenuByPlaceId(@PathVariable(value = "id") Long id, @RequestBody MenuReq req) {
        BeerMenu menu = beerMenuRepository.save(req.toEntity(
                placeRepository.getOne(id),
                beerRepository.getOne(req.getBeerId())
        ));
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/places/{id}/menu")
                .buildAndExpand(menu.getId().getPlaceId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Transactional
    @PostMapping
    public ResponseEntity savePlace(@RequestBody PlaceReq req) {
        Place place = placeRepository.save(req.toEntity());
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/places/{id}")
                .buildAndExpand(place.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
