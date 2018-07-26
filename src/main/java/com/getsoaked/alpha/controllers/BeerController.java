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

@AllArgsConstructor
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/beers")
public class BeerController {

    BeerRepository beerRepository;
    BreweryRepository breweryRepository;

    @Transactional(readOnly = true)
    @GetMapping
    public List<BeerRes> findAllBeers() {
        return beerRepository.findAll().stream().map(BeerRes::new).collect(Collectors.toList());
    } // pagination

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public BeerRes findOneBeer(@PathVariable(value = "id") Long id) {
        return new BeerRes(beerRepository.getOne(id));
    }

    @Transactional
    @PostMapping
    public ResponseEntity saveBeer(@RequestBody BeerReq req) {
        Beer beer = beerRepository.save(req.toEntity(breweryRepository.getOne(req.getBreweryId())));
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/beers/{id}")
                .buildAndExpand(beer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBeer(@PathVariable(value = "id") Long id) {
        beerRepository.deleteById(id);
        return ResponseEntity.ok().build(); // should add description to body
    }

    // add if-else into methods for other responses when the request fails
    // add a patch method
}
