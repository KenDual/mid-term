
package com.example.service;

import com.example.model.Order;
import com.example.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(int id) {
        return orderRepository.findById(id);
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public void update(Order order) {
        orderRepository.update(order);
    }

    public void delete(int id) {
        orderRepository.delete(id);
    }
}
