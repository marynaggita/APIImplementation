package com.example.LeaveRestApi.services;

import com.example.LeaveRestApi.models.CakeOrderRequest;
import com.example.LeaveRestApi.repository.CakeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;

@Service

public class CakeOrderService {

    private final CakeOrderRepository cakeOrderRepository;
    @Autowired
    public CakeOrderService(CakeOrderRepository cakeOrderRepository) {
        this.cakeOrderRepository = cakeOrderRepository;
    }

    public String submitOrderRequest(CakeOrderRequest orderRequest) {
        String name = orderRequest.getName();
        String email = orderRequest.getEmail();
        System.out.println("Received Leave Request:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);

        //CakeOrderRequest cakeOrderRequest = new CakeOrderRequest();

        orderRequest.setName(name);
        orderRequest.setEmail(email);

        // Process the data, save to the database, etc.
        cakeOrderRepository.save(orderRequest);
        // Return a response
        return "Cake order received and saved successfully!";


    }
}
