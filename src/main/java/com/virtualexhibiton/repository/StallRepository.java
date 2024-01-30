package com.virtualexhibiton.repository;

import com.virtualexhibiton.model.Stall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StallRepository extends JpaRepository<Stall, Long> {
    // Additional methods can be added for specific queries if needed
}
