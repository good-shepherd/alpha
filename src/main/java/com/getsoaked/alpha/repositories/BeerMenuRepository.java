package com.getsoaked.alpha.repositories;

import com.getsoaked.alpha.entities.BeerMenu;
import com.getsoaked.alpha.entities.CompositePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BeerMenuRepository extends JpaRepository<BeerMenu, CompositePK> {

    @Query(value = "SELECT * FROM beermenus b WHERE b.place_id = ?1", nativeQuery = true)
    List<BeerMenu> getAllByPlaceId(Long id);

}
