package com.example.Carrent1st.controller;


import com.example.Carrent1st.dto.LocationSearchRequest;
import com.example.Carrent1st.model.Car;
import com.example.Carrent1st.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/api/cars/near-location")
    public List<Car> findCarsNearLocation(@RequestBody LocationSearchRequest searchRequest) {
        double targetLatitude = searchRequest.getTargetLatitude();
        double targetLongitude = searchRequest.getTargetLongitude();
        double maxDistance = 100;
        return locationService.findCarsNearLocation(targetLatitude, targetLongitude, maxDistance);
    }
}
