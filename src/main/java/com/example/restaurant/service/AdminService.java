package com.example.restaurant.service;

import com.example.restaurant.model.Client;
import com.example.restaurant.model.Order;
import com.example.restaurant.model.OrderStatus;
import com.example.restaurant.repository.AdminRepositoryInterface;
import com.example.restaurant.repository.ClientRepositoryInterface;
import com.example.restaurant.repository.OrderRepositoryInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepositoryInterface adminRepositoryInterface;
    @Autowired
    OrderRepositoryInterface orderRepositoryInterface;
    @Autowired
    ClientRepositoryInterface clientRepositoryInterface;

    public Order acceptOrder(Long orderId){
        Order order = orderRepositoryInterface.findById(orderId).orElseThrow(EntityNotFoundException::new);
        if (order.getStatus() == OrderStatus.AWAITING_ACCEPTANCE && order.getClient().getBalance() >= order.getTotalPrice()) {
            order.setStatus(OrderStatus.COMPLETED);
            Client client = order.getClient();
            client.setBalance(client.getBalance() - order.getTotalPrice());
            clientRepositoryInterface.save(client);
        }
        return orderRepositoryInterface.save(order);
    }

    public void denyOrder(Long orderId){
        Order order = orderRepositoryInterface.findById(orderId).orElseThrow(EntityNotFoundException::new);
        orderRepositoryInterface.delete(order);
    }
}
