package com.getsoaked.alpha.controllers;

import com.getsoaked.alpha.services.PlaceService;
import com.getsoaked.alpha.payloads.MenuReq;
import com.getsoaked.alpha.payloads.MenuRes;
import com.getsoaked.alpha.payloads.PlaceReq;
import com.getsoaked.alpha.payloads.PlaceRes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/places")
public class PlaceController {

    PlaceService placeService;

    @GetMapping
    public List<PlaceRes> findAllPlaces() {
        return placeService.findAllPlaces();
    }

    @PostMapping
    public ResponseEntity savePlace(@RequestBody PlaceReq req) {
        return ResponseEntity.created(placeService.savePlace(req)).build();
    }

    @GetMapping("/{id}")
    public PlaceRes findOnePlace(@PathVariable(value = "id") Long id) {
        return placeService.findOnePlace(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updatePlace(@PathVariable(value = "id") Long id, @RequestBody PlaceReq req) {
        placeService.updatePlace(id, req);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePlace(@PathVariable(value = "id") Long id) {
        placeService.deletePlace(id);
        return ResponseEntity.ok().build();
    }

    // menus CRUD
    @GetMapping("/{id}/menu")
    public List<MenuRes> getMenuByPlaceId(@PathVariable(value = "id") Long id) {
        return placeService.getMenuByPlaceId(id);
    }

    @PostMapping("/{id}/menu")
    public ResponseEntity saveMenuByPlaceId(@PathVariable(value = "id") Long id, @RequestBody MenuReq req) {
        return ResponseEntity.created(placeService.saveMenuByPlaceId(id, req)).build();
    }

    @DeleteMapping("/{id}/menu/{bid}")
    public ResponseEntity deleteBrewery(@PathVariable(value = "id") Long id, @PathVariable(value = "bid") Long bid) {
        placeService.deleteMenuById(id, bid);
        return ResponseEntity.ok().build();
    }
}
