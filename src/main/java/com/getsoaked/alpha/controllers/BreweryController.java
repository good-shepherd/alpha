package com.getsoaked.alpha.controllers;

import com.getsoaked.alpha.Services.BreweryService;
import com.getsoaked.alpha.payloads.BreweryReq;
import com.getsoaked.alpha.payloads.BreweryRes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/breweries")
public class BreweryController {

    BreweryService breweryService;

    @GetMapping
    public List<BreweryRes> findAllBreweries() {
        return breweryService.findAllBreweries();
    }

    @GetMapping("/{id}")
    public BreweryRes findOneBrewery(@PathVariable(value = "id") Long id) {
        return breweryService.findOneBrewery(id);
    }

    @PostMapping
    public ResponseEntity saveBrewery(@RequestBody BreweryReq req) {
        return ResponseEntity.created(breweryService.saveBrewery(req)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateBrewery(@PathVariable(value = "id") Long id, @RequestBody BreweryReq req) {
        breweryService.updateBrewery(id, req);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBrewery(@PathVariable(value = "id") Long id) {
        breweryService.deleteBrewery(id);
        return ResponseEntity.ok().build(); // should add description to body
    } // when deleting, it deletes all of beers of the brewery's. this needs to be refactored to disable the brewery not to delete.

    // add if-else into methods for other responses when the request fails
    // add a patch method
}
