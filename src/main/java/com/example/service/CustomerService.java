
package com.example.service;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    public void delete(int id) {
        customerRepository.delete(id);
    }
}
