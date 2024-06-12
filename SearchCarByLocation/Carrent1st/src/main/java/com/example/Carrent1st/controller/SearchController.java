package com.example.Carrent1st.controller;


import com.example.Carrent1st.model.Car;
import com.example.Carrent1st.services.LocationService;
import com.example.Carrent1st.dto.LocationSearchRequest;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SearchController {

    private final LocationService locationService;

  
    public SearchController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/api/search")
    public List<Car> searchNearbyCars(@RequestBody LocationSearchRequest locationRequest) {
        // Delegate the search operation to the service layer
        double maxDistance = 10; // Adjust as needed
        double targetLatitude = locationRequest.getTargetLatitude();
        double targetLongitude = locationRequest.getTargetLongitude();
        return locationService.findCarsNearLocation(targetLatitude, targetLongitude, maxDistance);
    }
}
