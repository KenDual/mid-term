
package com.example.repository;

import com.example.model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setAddress(rs.getString("address"));
        customer.setNumber(rs.getString("phone_number"));
        customer.setEmail(rs.getString("email"));
        return customer;
    }

    public List<Customer> findAll() {
        String sql = "SELECT * FROM Customer";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public Customer findById(int id) {
        String sql = "SELECT * FROM Customer WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRow, id);
    }

    public void save(Customer customer) {
        String sql = "INSERT INTO Customer (name, phone_number, email, address) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, customer.getName(), customer.getNumber(), customer.getEmail(), customer.getAddress());
    }

    public void update(Customer customer) {
        String sql = "UPDATE Customer SET name = ?, phone_number = ?, email = ?, address = ? WHERE id = ?";
        jdbcTemplate.update(sql, customer.getName(), customer.getNumber(), customer.getEmail(), customer.getAddress(), customer.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Customer WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
