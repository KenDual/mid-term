
package com.example.repository;

import com.example.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setBranch(rs.getString("branch"));
        employee.setEmail(rs.getString("email"));
        employee.setNumber(rs.getString("number"));
        return employee;
    }

    public List<Employee> findAll() {
        String sql = "SELECT * FROM Car";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public Employee findById(int id) {
        String sql = "SELECT * FROM Car WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRow, id);
    }

    public void save(Employee employee) {
        String sql = "INSERT INTO Car (id, name, brand, manufacture_year, category_id, branch_id) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getBranch(), employee.getEmail(), employee.getNumber());
    }

    public void update(Employee employee) {
        String sql = "UPDATE Car SET name = ?, brand = ?, manufacture_year = ?, category_id = ?, branch_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getBranch(), employee.getEmail(), employee.getNumber());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Car WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
