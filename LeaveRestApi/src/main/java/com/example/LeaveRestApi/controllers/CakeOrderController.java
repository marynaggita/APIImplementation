package com.example.LeaveRestApi.controllers;

import com.example.LeaveRestApi.models.CakeOrderRequest;
import com.example.LeaveRestApi.services.CakeOrderService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CakeOrderController {
    final CakeOrderService cakeOrderService;
    @Autowired
    public CakeOrderController(CakeOrderService cakeOrderService) {
        this.cakeOrderService = cakeOrderService;
    }

    @GetMapping("/orderSearch")
    public ResponseEntity<?> searchOrderByName(@RequestParam String name) {
        List<CakeOrderRequest> getResults = cakeOrderService.getOrderByName(name);
        if (getResults.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(getResults);
        }
    }
    @PostMapping("/orderRequest")
    public String submitCakeOrderRequest(@RequestBody CakeOrderRequest cakeOrderRequest) {
        return cakeOrderService.submitOrderRequest(cakeOrderRequest);
    }
    @DeleteMapping("/deleteOrder")
    public ResponseEntity<String> deleteOrder(@RequestParam Long id) {
        try {
            cakeOrderService.deleteOrderById(id);
            return ResponseEntity.ok("Order deleted successfully");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Order");
        }
    }

}
