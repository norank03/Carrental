package com.example.Carrent1st.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carrent1st.model.Car;
import com.example.Carrent1st.model.Car.Status;
import com.example.Carrent1st.repository.CarRepository;
@Service
public class searchByproperites {
    
@Autowired
public CarRepository carRepository ;


public List<Car> findAvailableCarsByModelAndPrice(String model, BigDecimal maxPrice) {
    List<Car> allCars = carRepository.findAll();
    return allCars.stream()
            .filter(car -> car.getStatus() != null && car.getStatus().equals(Status.avalible))
            .filter(car -> car.getName().equalsIgnoreCase(model)) // Filter by model (case insensitive)
            .filter(car -> car.getPrice().compareTo(maxPrice) <= 0) // Filter by price
            .collect(Collectors.toList());
}



}
