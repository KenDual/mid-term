
package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // Hiển thị danh sách
    @GetMapping
    public String listCustomer(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "view";
    }

    // Hiển thị form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "list-form-customer";
    }

    // Hiển thị form cập nhật
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "list-form-customer";
    }

    // Xử lý cập nhật
    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerService.update(customer);
        return "redirect:/customers";
    }
    
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute Customer customer) {
        if (customer.getId() == 0 || customer.getId() <0){
            customerService.save(customer);
        } else {
            customerService.update(customer);
        }
        return "redirect:/customers";
    }

    // Xử lý xóa
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        customerService.delete(id);
        return "redirect:/customers";
    }
}
