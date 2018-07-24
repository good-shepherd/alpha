package com.getsoaked.alpha.repositories;

import com.getsoaked.alpha.entities.Pub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PubRepository extends JpaRepository<Pub, Long> {
}
