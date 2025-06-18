
package com.example.repository;

import com.example.model.Car;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setName(rs.getString("name"));
        car.setBrand(rs.getString("brand"));
        car.setYear(rs.getInt("year"));
        car.setCategory_id(rs.getInt("category_id"));
        car.setBranch_id(rs.getInt("branch_id"));
        return car;
    }

    public List<Car> findAll() {
        String sql = "SELECT * FROM Car";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public Car findById(int id) {
        String sql = "SELECT * FROM Car WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRow, id);
    }

    public void save(Car car) {
        String sql = "INSERT INTO Car (name, brand, year, category_id, branch_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getName(), car.getBrand(), car.getYear(), car.getCategory_id(), car.getBranch_id());
    }

    public void update(Car car) {
        String sql = "UPDATE Car SET name = ?, brand = ?, year = ?, category_id = ?, branch_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, car.getName(), car.getBrand(), car.getYear(), car.getCategory_id(), car.getBranch_id(), car.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Car WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
