package com.example.Carrent1st.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carrent1st.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {




    
}
