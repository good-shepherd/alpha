package com.getsoaked.alpha.repositories;

import com.getsoaked.alpha.entities.BeerMenu;
import com.getsoaked.alpha.entities.CompositePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerMenuRepository extends JpaRepository<BeerMenu, CompositePK> {
}
