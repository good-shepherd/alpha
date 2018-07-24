package com.getsoaked.alpha.repositories;

import com.getsoaked.alpha.entities.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweryRepository extends JpaRepository<Brewery, Long> {
}
