package com.getsoaked.alpha.repositories;

import com.getsoaked.alpha.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {

}
