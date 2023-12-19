package com.example.LeaveRestApi.controllers;

import com.example.LeaveRestApi.models.CakeOrderRequest;
import com.example.LeaveRestApi.services.CakeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CakeOrderController {
    final CakeOrderService cakeOrderService;
    @Autowired
    public CakeOrderController(CakeOrderService cakeOrderService) {
        this.cakeOrderService = cakeOrderService;
    }
    @PostMapping("/cakeOrderRequest")
    public String submitCakeOrderRequest(@RequestBody CakeOrderRequest cakeOrderRequest) {
        return cakeOrderService.submitOrderRequest(cakeOrderRequest);
    }

}
