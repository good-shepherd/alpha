package com.getsoaked.alpha.controllers;

import com.getsoaked.alpha.entities.Beer;
import com.getsoaked.alpha.payloads.BeerReq;
import com.getsoaked.alpha.payloads.BeerRes;
import com.getsoaked.alpha.repositories.BeerRepository;
import com.getsoaked.alpha.repositories.BreweryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("/beers")
public class BeerController {

    BeerRepository beerRepository;
    BreweryRepository breweryRepository;


    @GetMapping
    public List<BeerRes> findAllBeers() {
        return beerRepository.findAll().stream().map(BeerRes::new).collect(Collectors.toList());
    }

    @Transactional
    @PostMapping
    public ResponseEntity saveBeer(BeerReq req) {
        Beer beer = beerRepository.save(Beer.builder()
                .name(req.getName())
                .abv(req.getAbv())
                .type(req.getType())
                .description(req.getDescription())
                .brewery(breweryRepository.getOne(req.getBreweryId()))
                .build());
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/beers/{id}")
                .buildAndExpand(beer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
