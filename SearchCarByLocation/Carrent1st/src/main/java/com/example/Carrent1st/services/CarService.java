package com.example.Carrent1st.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.example.Carrent1st.dto.CarRequest;
import com.example.Carrent1st.dto.CarResponse;
import com.example.Carrent1st.model.Car;
import com.example.Carrent1st.model.User;
import com.example.Carrent1st.repository.CarRepository;
import com.example.Carrent1st.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarService {

    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public CarService(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public void createCar(CarRequest carRequest) {
        Optional<User> user = userRepository.findById(carRequest.getUser_id());
            
        // Create the Car object and set the User
        Car car = Car.builder()
                .name(carRequest.getName())
                .description(carRequest.getDescription())
                .price(carRequest.getPrice())
                .longitude(carRequest.getLongitude())
                .latitude(carRequest.getLatitude())
                .status(carRequest.getStatus())
                .user(user.get()) 
                .build();

        carRepository.save(car);
        log.info("Car {} is saved", car.getId());
    }

    public List<CarResponse> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(this::mapToCarResponse).collect(Collectors.toList());
    }

    private CarResponse mapToCarResponse(Car car) {
        return CarResponse.builder()
                .id(car.getId())
                .name(car.getName())
                .description(car.getDescription())
                .price(car.getPrice())
                .build();
    }
}
