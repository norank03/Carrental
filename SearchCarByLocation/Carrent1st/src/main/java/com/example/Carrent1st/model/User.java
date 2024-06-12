package com.example.Carrent1st.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id ;

    @Column(name = "username")
     private String name ;


    @Column(name = "email")
    private String email ;

    @Column(name = "phone")
   
    private String phone ;

    @Column(name = "password")
    
    private String password ;
      
 




    public enum Role {


        CONSUMER,
        SERVICE_PROVIDER,
        ADMIN
    }

    @Column(name = "role")
    @Enumerated(EnumType.STRING) // this annoation to tell spring that role is an enum
    private Role role ;




}
