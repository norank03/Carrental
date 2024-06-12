package com.example.Carrent1st.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CarSearchRequest {

    private String model;
    private BigDecimal maxPrice;

    public CarSearchRequest() {}

    public CarSearchRequest(String model, BigDecimal maxPrice) {
        this.model = model;
        this.maxPrice = maxPrice;
    }
}

