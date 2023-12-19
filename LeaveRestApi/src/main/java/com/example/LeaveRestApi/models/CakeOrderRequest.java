package com.example.LeaveRestApi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity

public class CakeOrderRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Replace with your meaningful identifier field

    private String name;
    private String email;

    public CakeOrderRequest() {
        this.name = name;
        this.email = email;
        // You can set default values or perform other initialization here
    }

}
