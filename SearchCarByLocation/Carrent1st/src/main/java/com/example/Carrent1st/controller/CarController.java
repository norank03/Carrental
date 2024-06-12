package com.example.Carrent1st.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

import com.example.Carrent1st.dto.CarRequest;
import com.example.Carrent1st.dto.CarResponse;
import com.example.Carrent1st.dto.CarSearchRequest;
import com.example.Carrent1st.model.Car;
import com.example.Carrent1st.services.CarService;
import com.example.Carrent1st.services.searchByproperites;

@RestController
@RequestMapping("/api/Car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService; // Use final for injection

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCar(@RequestBody CarRequest carRequest) {
        carService.createCar(carRequest); // Invoke createProduct method from CarService
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<CarResponse> getAllCars() {
        return carService.getAllCars(); // Invoke getAllProducts method from CarService
    }



    @Autowired
    private searchByproperites searching;

    @PostMapping("/cars/properites")
    public List<Car> findAvailableCarsByModelAndPrice(@RequestBody CarSearchRequest request) {
        return searching.findAvailableCarsByModelAndPrice(request.getModel(), request.getMaxPrice());
    }



    
}






  