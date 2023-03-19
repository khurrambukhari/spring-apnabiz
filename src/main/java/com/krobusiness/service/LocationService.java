package com.krobusiness.service;

import java.util.List;

import com.krobusiness.model.entities.Location;
import com.krobusiness.model.entities.enums.LocationEnum;

public interface LocationService {
    List<Location> initLocations();

    Location getLocationByName(LocationEnum locationEnum);
}
