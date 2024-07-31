package org.example.repository;

import org.example.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    //the method for finding last turnout
    @Query("SELECT r FROM Region r WHERE r.dateTime = (SELECT MAX(r2.dateTime) FROM Region r2)")
    Optional<Region> findLatestRegion();
}
