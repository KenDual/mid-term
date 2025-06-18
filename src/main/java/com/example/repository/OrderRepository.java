
package com.example.repository;

import com.example.model.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setDate(rs.getDate("date"));
        order.setCustomer(rs.getString("customer"));
        order.setCar(rs.getString("car"));
        order.setEmployee(rs.getString("employee"));
        order.setDiscount(rs.getDouble("discount"));
        return order;
    }

    public List<Order> findAll() {
        String sql = "SELECT * FROM Car";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public Order findById(int id) {
        String sql = "SELECT * FROM Car WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRow, id);
    }

    public void save(Order order) {
        String sql = "INSERT INTO Car (id, name, brand, manufacture_year, category_id, branch_id) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getId(), order.getDate(), order.getCustomer(), order.getCar(), order.getEmployee(), order.getDiscount());
    }

    public void update(Order order) {
        String sql = "UPDATE Car SET name = ?, brand = ?, manufacture_year = ?, category_id = ?, branch_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, order.getId(), order.getDate(), order.getCustomer(), order.getCar(), order.getEmployee(), order.getDiscount());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Car WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
