package org.example.dao;
import org.example.models.Employee;
import org.example.models.Job;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    // todo table methods
    void createEmployeeTable();
    void dropEmployeeTable();
    void cleanEmployeeTable();

    // todo employee methods
    void addEmployee (Employee employee);
    Employee getEmployeeByEmail (String email);
    Map<Employee, Job> getEmployeeById (Long id);
    List<Employee> getAllEmployees();
    void updateEmployee (Long id, Employee employee);
    List<Employee> getEmployeesByPosition (String position);
}
