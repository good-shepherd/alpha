package com.getsoaked.alpha.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
@Slf4j
public class FileUploadController {

    // Test
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/upload")
    public ResponseEntity uploadFile(MultipartFile file) {
        System.out.println("--------------------------------");
        System.out.println(file.getSize());
        System.out.println(file.getOriginalFilename());
        System.out.println("--------------------------------");
        return null;
    }
}