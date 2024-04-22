package com.example.restaurant.repository;

import com.example.restaurant.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepositoryInterface extends JpaRepository<Order, Long> {

    @Query(value = "select * from orders order by id", nativeQuery = true)
    List<Order> getAll();

}
