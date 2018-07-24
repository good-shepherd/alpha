package com.getsoaked.alpha.controllers;

import com.getsoaked.alpha.entities.Brewery;
import com.getsoaked.alpha.payloads.BreweryReq;
import com.getsoaked.alpha.repositories.BreweryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("/breweries")
public class BreweryController {

    BreweryRepository breweryRepository;

    @GetMapping
    public List<Brewery> findAllBreweries() {
        return breweryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity saveBrewery(BreweryReq req) {
        Brewery brewery = breweryRepository.save(Brewery.builder()
                .name(req.getName())
                .address(req.getAddress())
                .phone(req.getPhone())
                .x(req.getX())
                .y(req.getY())
                .build());
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/breweries/{id}")
                .buildAndExpand(brewery.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
