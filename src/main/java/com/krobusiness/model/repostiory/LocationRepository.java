package com.krobusiness.model.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krobusiness.model.entities.Location;
import com.krobusiness.model.entities.enums.LocationEnum;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByName(LocationEnum locationEnum);
}
