
package com.example.repository;


import com.example.model.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setId(rs.getInt("id"));
        category.setName(rs.getString("name"));
        category.setNote(rs.getString("note"));
        return category;
    }

    public List<Category> findAll() {
        String sql = "SELECT * FROM Category";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public Category findById(int id) {
        String sql = "SELECT * FROM Category WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRow, id);
    }

    public void save(Category category) {
        String sql = "INSERT INTO Category (name, note) VALUES (?, ?)";
        jdbcTemplate.update(sql, category.getName(), category.getNote());
    }

    public void update(Category category) {
        String sql = "UPDATE Category SET name = ?, note = ?, WHERE id = ?";
        jdbcTemplate.update(sql, category.getName(), category.getNote());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Category WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
