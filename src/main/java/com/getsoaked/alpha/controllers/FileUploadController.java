package com.getsoaked.alpha.controllers;

import com.getsoaked.alpha.entities.Brewery;
import com.getsoaked.alpha.repositories.BeerRepository;
import com.getsoaked.alpha.repositories.BreweryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
@RestController
@Slf4j
public class FileUploadController {

    BeerRepository beerRepository;
    BreweryRepository breweryRepository;

    // Test
    @PostMapping("/api/upload")
    public ResponseEntity uploadFile(MultipartFile file) {
        System.out.println("--------------------------------");
        System.out.println(file.getSize());
        System.out.println(file.getOriginalFilename());
        System.out.println("--------------------------------");
        return null;
    }

    @GetMapping("/api/test")
    public void testApi() {
        Brewery brewery = breweryRepository.getOne(1l);
        System.out.println("----------------------");
        System.out.println(brewery.getName());
        System.out.println("----------------------");
        brewery.getBeers().forEach(o -> System.out.println(o.getName()));
    }
}