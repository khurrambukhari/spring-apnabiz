package com.krobusiness.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krobusiness.handler.NotFoundException;
import com.krobusiness.model.entities.Location;
import com.krobusiness.model.entities.enums.LocationEnum;
import com.krobusiness.model.repostiory.LocationRepository;
import com.krobusiness.service.LocationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> initLocations() {
        List<Location> init = new ArrayList<>();
        if (locationRepository.count() == 0) {
            Arrays.stream(LocationEnum.values()).forEach(locationEnum -> {
                Location location = new Location(locationEnum);
                this.locationRepository.save(location);
                init.add(location);
            });
        }
        return init;
    }

    @Override
    public Location getLocationByName(LocationEnum locationEnum) {
        Optional<Location> location = this.locationRepository.findByName(locationEnum);
        if (location.isPresent()) {
            return location.get();
        } else {
            throw new NotFoundException("Location not found");
        }
    }
}
