
package com.example.service;

import com.example.model.Car;
import com.example.repository.CarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(int id) {
        return carRepository.findById(id);
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public void update(Car car) {
        carRepository.update(car);
    }

    public void delete(int id) {
        carRepository.delete(id);
    }
}
