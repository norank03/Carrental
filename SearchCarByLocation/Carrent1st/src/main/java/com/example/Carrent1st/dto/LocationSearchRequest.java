package com.example.Carrent1st.dto;

import lombok.Data;

@Data
public class LocationSearchRequest {
    private double targetLatitude;
    private double targetLongitude;
    private double maxDistance;
}
