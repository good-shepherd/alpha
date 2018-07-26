package com.getsoaked.alpha.controllers;

import com.getsoaked.alpha.entities.Brewery;
import com.getsoaked.alpha.payloads.BreweryReq;
import com.getsoaked.alpha.payloads.BreweryRes;
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
@RequestMapping("/api/breweries")
public class BreweryController {

    BreweryRepository breweryRepository;

    @Transactional(readOnly = true)
    @GetMapping
    public List<BreweryRes> findAllBreweries() {
        return breweryRepository.findAll().stream().map(BreweryRes::new).collect(Collectors.toList());
    } // pagination

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public BreweryRes findOneBrewery(@PathVariable(value = "id") Long id) {
        return new BreweryRes(breweryRepository.getOne(id));
    }

    @Transactional
    @PostMapping
    public ResponseEntity saveBrewery(@RequestBody BreweryReq req) {
        Brewery brewery = breweryRepository.save(req.toEntity());
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/breweries/{id}")
                .buildAndExpand(brewery.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBrewery(@PathVariable(value = "id") Long id) {
        breweryRepository.deleteById(id);
        return ResponseEntity.ok().build(); // should add description to body
    }

    // add if-else into methods for other responses when the request fails
    // add a patch method
}
