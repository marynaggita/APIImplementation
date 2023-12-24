package com.example.LeaveRestApi.services;

import com.example.LeaveRestApi.models.CakeOrderRequest;
import com.example.LeaveRestApi.repository.CakeOrderRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        System.out.println("Received Cake Order Request:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);

        orderRequest.setName(name);
        orderRequest.setEmail(email);

        // Process the data, save to the database, etc.
        cakeOrderRepository.save(orderRequest);
        // Return a response
        return "Cake order received and saved successfully!";


    }
    public void deleteOrderById(Long orderId) {
        cakeOrderRepository.deleteById(orderId);
    }
    public List<CakeOrderRequest> getOrderByName(String name) {
        return cakeOrderRepository.findByName(name);
    }


    public CakeOrderRequest updateOrder(CakeOrderRequest updatedOrder) {
        Optional<CakeOrderRequest> existingOrderOptional = cakeOrderRepository.findById(updatedOrder.getId());

        if(existingOrderOptional.isPresent()){
            CakeOrderRequest existingOrder = existingOrderOptional.get();

            existingOrder.setName(updatedOrder.getName());
            existingOrder.setEmail(updatedOrder.getEmail());

            System.out.println("SuccessFully Updated");
            return cakeOrderRepository.save(existingOrder);
        } else {
            return null;
        }

    }

    public Optional<CakeOrderRequest> getOrderById (Long id){
        return  cakeOrderRepository.findById(id);
    }
}
