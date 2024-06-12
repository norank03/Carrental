package com.example.Carrent1st.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
   
        private long id;
        private String name;
        private String description;
        private BigDecimal price;
        private long longitude; 
        private long latitude; 
        private long user_id ;
    }  

