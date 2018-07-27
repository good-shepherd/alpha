package com.getsoaked.alpha.Services;

import com.getsoaked.alpha.entities.Brewery;
import com.getsoaked.alpha.payloads.BreweryReq;
import com.getsoaked.alpha.payloads.BreweryRes;
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
public class BreweryService {

    BreweryRepository breweryRepository;

    @Transactional(readOnly = true)
    public List<BreweryRes> findAllBreweries() {
        return breweryRepository.findAll().stream().map(BreweryRes::new).collect(Collectors.toList());
    } // pagination

    @Transactional(readOnly = true)
    public BreweryRes findOneBrewery(Long id) {
        return new BreweryRes(breweryRepository.getOne(id));
    }

    @Transactional
    public URI saveBrewery(BreweryReq req) {
        Brewery brewery = breweryRepository.save(req.toEntity());
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/breweries/{id}")
                .buildAndExpand(brewery.getId()).toUri();
        return location;
    }

    @Transactional
    public void deleteBrewery(Long id) {
        breweryRepository.deleteById(id);
    }

}
