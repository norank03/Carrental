package com.example.Carrent1st.services;


import com.example.Carrent1st.model.Car;
import com.example.Carrent1st.model.Car.Status;
import com.example.Carrent1st.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findCarsNearLocation(double targetLatitude, double targetLongitude, double maxDistance) {
       
        List<Car> allCars = carRepository.findAll();
        return allCars.stream()
            .filter(car -> car.getStatus() != null && car.getStatus().equals(Status.avalible)) // Filter by status
            .filter(car -> calculateDistance(car.getLatitude(), car.getLongitude(), targetLatitude, targetLongitude) <= maxDistance)
            .collect(Collectors.toList());
    }

    private static final double EARTH_RADIUS = 6371; // Earth radius in kilometers

// Method to calculate distance between two points using Haversine formula
private double calculateDistance(double bigDecimal, double bigDecimal2, double lat2, double lon2) {
    // Convert latitude and longitude from degrees to radians
    double lat1Rad = Math.toRadians(bigDecimal);
    double lon1Rad = Math.toRadians(bigDecimal2);
    double lat2Rad = Math.toRadians(lat2);
    double lon2Rad = Math.toRadians(lon2);

    // Calculate the differences between the coordinates
    double deltaLat = lat2Rad - lat1Rad;
    double deltaLon = lon2Rad - lon1Rad;

    // Calculate the distance using the Haversine formula
    double a = Math.pow(Math.sin(deltaLat / 2), 2) +
               Math.cos(lat1Rad) * Math.cos(lat2Rad) *
               Math.pow(Math.sin(deltaLon / 2), 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distance = EARTH_RADIUS * c;

    return distance; // Distance in kilometers
}

}
