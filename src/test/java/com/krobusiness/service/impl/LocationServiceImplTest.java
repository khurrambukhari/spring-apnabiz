package com.krobusiness.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.krobusiness.handler.NotFoundException;
import com.krobusiness.model.entities.Location;
import com.krobusiness.model.entities.enums.LocationEnum;
import com.krobusiness.model.repostiory.LocationRepository;
import com.krobusiness.service.LocationService;
import com.krobusiness.service.impl.LocationServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class LocationServiceImplTest {
    private LocationRepository mockLocationRepository;
    private LocationService locationServiceToTest;
    private Location location;

    @BeforeEach
    public void setUp() {
        mockLocationRepository = mock(LocationRepository.class);
        locationServiceToTest = new LocationServiceImpl(mockLocationRepository);
        location = new Location();
        location.setName(LocationEnum.ZURICH);
    }

    @Test
    void getLocationByName_should_work() {
        Mockito.when(mockLocationRepository.findByName(LocationEnum.ZURICH)).
                thenReturn(Optional.of(location));
        Location locationByName = locationServiceToTest.getLocationByName(LocationEnum.ZURICH);

        assertEquals(location.getName(), locationByName.getName());
    }

    @Test
    void testLocationNotFound() {
        Assertions.assertThrows(
                NotFoundException.class,
                () -> locationServiceToTest.getLocationByName(LocationEnum.ZURICH));
    }

    @Test
    void initLocations_should_work() {
        locationServiceToTest.initLocations();
        assertEquals(4, locationServiceToTest.initLocations().size());
    }
}