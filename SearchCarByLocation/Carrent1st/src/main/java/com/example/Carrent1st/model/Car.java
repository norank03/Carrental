package com.example.Carrent1st.model;
import lombok.Builder;
import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "CarData")

public class Car {
    

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer id;

    @Column(name = "carModel")
    private String name;

    @Column(name = "des")
    private String description;

    @Column(name = "price")
    private BigDecimal price;


public enum Status {
    rented,
    avalible
    
}

@Column(name = "status")
@Enumerated(EnumType.STRING)
private Status status;

@Column(name="latitude")
private Double latitude;

@Column(name="longitude")
private Double longitude;

    @ManyToOne // Lazy fetch to avoid loading the User entity eagerly
    @JoinColumn(name = "user_id") // Name of the foreign key column in the car_data table
    private User user;


   
}