package com.getsoaked.alpha.repositories;

import com.getsoaked.alpha.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
