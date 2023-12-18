package com.example.LeaveRestApi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CakeOrderRequest {
    private String name;
    private String email;
}
