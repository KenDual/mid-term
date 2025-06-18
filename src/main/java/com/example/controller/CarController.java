package com.example.controller;

import com.example.model.Car;
import com.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // Hiển thị danh sách 
    @GetMapping
    public String listBranches(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "view";
    }

    // Hiển thị form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("car", new Car());
        return "list-form-car";
    }

    // Hiển thị form cập nhật
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Car car = carService.findById(id);
        model.addAttribute("car", car);
        return "list-form-car";
    }

    // Xử lý cập nhật
    @PostMapping("/edit")
    public String updateCar(@ModelAttribute Car car) {
        carService.update(car);
        return "redirect:/cars";
    }
    
    @PostMapping("/save")
    public String saveCar(@ModelAttribute Car car) {
        if (car.getId() == 0 || car.getId() <0){
            carService.save(car);
        } else {
            carService.update(car);
        }
        return "redirect:/cars";
    }

    // Xử lý xóa
    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") int id) {
        carService.delete(id);
        return "redirect:/branches";
    }
}
