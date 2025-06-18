package com.example.repository;

import com.example.model.Branch;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BranchRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Branch mapRow(ResultSet rs, int rowNum) throws SQLException {
        Branch branch = new Branch();
        branch.setId(rs.getInt("id"));
        branch.setName(rs.getString("name"));
        branch.setAddress(rs.getString("address"));
        branch.setNumber(rs.getString("phone_number"));
        branch.setManager_id(rs.getInt("manager_id"));
        return branch;
    }

    public List<Branch> findAll() {
        String sql = "SELECT * FROM Branch";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public Branch findById(int id) {
        String sql = "SELECT * FROM Branch WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRow, id);
    }

    public void save(Branch branch) {
        String sql = "INSERT INTO Branch (name, address, phone_number, manager_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, branch.getName(), branch.getAddress(), branch.getNumber(), branch.getManager_id());
    }

    public void update(Branch branch) {
        String sql = "UPDATE Branch SET name = ?, address = ?, phone_number = ?, manager_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, branch.getName(), branch.getAddress(), branch.getNumber(), branch.getManager_id(), branch.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Branch WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
