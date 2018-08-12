package com.getsoaked.alpha.controllers;

import com.getsoaked.alpha.services.BeerService;
import com.getsoaked.alpha.payloads.BeerReq;
import com.getsoaked.alpha.payloads.BeerRes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/beers")
public class BeerController {

    BeerService beerService;

    @GetMapping
    public List<BeerRes> findAllBeers() {
        return beerService.findAllBeers();
    }

    @GetMapping("/{id}")
    public BeerRes findOneBeer(@PathVariable(value = "id") Long id) {
        return beerService.findOneBeer(id);
    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody BeerReq req) {
        return ResponseEntity.created(beerService.saveBeer(req)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateBeer(@PathVariable(value = "id") Long id, @RequestBody BeerReq req) {
        beerService.updateBeer(id, req);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBeer(@PathVariable(value = "id") Long id) {
        beerService.deleteBeer(id); // should add description to body
        return ResponseEntity.ok().build();
    }

    // add if-else into methods for other responses when the request fails
    // add a patch method
}
