package com.example.LeaveRestApi.repository;

import com.example.LeaveRestApi.models.CakeOrderRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CakeOrderRepository extends JpaRepository<CakeOrderRequest, Long> {
    List<CakeOrderRequest> findByName(String name);

    // Find orders by email
    List<CakeOrderRequest> findByEmail(String email);

    // Find orders by name and email
    List<CakeOrderRequest> findByNameAndEmail(String name, String email);

    // Find orders by name containing a specific substring
    List<CakeOrderRequest> findByNameContaining(String substring);

    // Custom JPQL query to find orders by a specific property
    @Query("SELECT c FROM CakeOrderRequest c WHERE c.someProperty = :propertyValue")
    List<CakeOrderRequest> findBySomeProperty(@Param("propertyValue") String propertyValue);

    // Custom native SQL query to find orders by a specific property
    @Query(value = "SELECT * FROM cake_order WHERE some_property = :propertyValue", nativeQuery = true)
    List<CakeOrderRequest> findBySomePropertyNativeQuery(@Param("propertyValue") String propertyValue);

    // Count the number of orders
    long count();

    // Delete orders by name
    void deleteByName(String name);

    // Update orders by setting a property to a new value
    @Query("UPDATE CakeOrderRequest c SET c.someProperty = :newPropertyValue WHERE c.id = :orderId")
    int updateSomeProperty(@Param("orderId") Long orderId, @Param("newPropertyValue") String newPropertyValue);

}
