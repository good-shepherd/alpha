package com.getsoaked.alpha.services;

import com.getsoaked.alpha.entities.Beer;
import com.getsoaked.alpha.payloads.BeerReq;
import com.getsoaked.alpha.payloads.BeerRes;
import com.getsoaked.alpha.repositories.BeerRepository;
import com.getsoaked.alpha.repositories.BreweryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BeerService {

    BeerRepository beerRepository;
    BreweryRepository breweryRepository;

    @Transactional(readOnly = true)
    public List<BeerRes> findAllBeers() {
        return beerRepository.findAll().stream().map(BeerRes::new).collect(Collectors.toList());
    } // pagination

    @Transactional(readOnly = true)
    public BeerRes findOneBeer(Long id) {
        return new BeerRes(beerRepository.getOne(id));
    }

    @Transactional
    public URI saveBeer(BeerReq req) {
        Beer beer = beerRepository.save(req.toEntity(breweryRepository.getOne(req.getBreweryId())));
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/beers/{id}")
                .buildAndExpand(beer.getId()).toUri();
        return location;
    }

    @Transactional
    public void updateBeer(Long id, BeerReq req) {
        Beer beer = beerRepository.getOne(id);
        beer.updateBeer(req, breweryRepository.getOne(req.getBreweryId()));
        beerRepository.save(beer);
    }

    @Transactional
    public void deleteBeer(Long id) {
        beerRepository.deleteById(id);
    }

}
