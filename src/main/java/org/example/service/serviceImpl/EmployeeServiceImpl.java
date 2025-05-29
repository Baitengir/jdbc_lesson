package org.example.service.serviceImpl;

import org.example.dao.EmployeeDao;
import org.example.dao.daoImpl.EmployeeDaoImpl;
import org.example.models.Employee;
import org.example.models.Job;
import org.example.service.EmployeeService;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    final EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Override
    public void createEmployeeTable() {
        employeeDao.createEmployeeTable();
    }

    @Override
    public void dropEmployeeTable() {
        employeeDao.dropEmployeeTable();
    }

    @Override
    public void cleanEmployeeTable() {
        employeeDao.cleanEmployeeTable();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeDao.getEmployeeByEmail(email);
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        employeeDao.updateEmployee(id, employee);
    }

    @Override
    public List<Employee> getEmployeesByPosition(String position) {
        return employeeDao.getEmployeesByPosition(position);
    }
}
