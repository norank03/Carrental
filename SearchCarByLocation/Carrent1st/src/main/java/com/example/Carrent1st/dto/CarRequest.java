package com.example.Carrent1st.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Carrent1st.model.Car.Status; // Import the Status enum


import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Double longitude;
    private Double latitude;
    private Status status; // Use the Status enum from Car model
    private Integer user_id;
}
