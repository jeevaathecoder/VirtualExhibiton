package com.virtualexhibiton.repository;

import com.virtualexhibiton.model.Exhibitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitorRepository extends JpaRepository<Exhibitor, Long> {
    // Additional methods can be added for specific queries if needed
}