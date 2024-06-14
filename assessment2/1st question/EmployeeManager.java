package com.example.manager;

import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeManager {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO Employees (name, department) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment());
    }

    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM Employees";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM Employees WHERE id = ?";
        List<Employee> employees = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Employee.class));
        return employees.isEmpty() ? null : employees.get(0);
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE Employees SET name = ?, department = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getId());
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employees WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
