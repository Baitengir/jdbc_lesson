package org.example.dao.daoImpl;
import org.example.config.DBConnection;
import org.example.dao.EmployeeDao;
import org.example.models.Employee;
import org.example.models.Job;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {
    Connection connection = DBConnection.getConnection();
    @Override
    public void createEmployeeTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS employees (
                id SERIAL PRIMARY KEY,
                first_name VARCHAR(50) NOT NULL,
                last_name VARCHAR(50) NOT NULL,
                age INTEGER NOT NULL CHECK (age > 0),
                email VARCHAR(50) UNIQUE NOT NULL,
                job_id INTEGER REFERENCES employees(id) )
                """;
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Employee table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropEmployeeTable() {

    }

    @Override
    public void cleanEmployeeTable() {

    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return null;
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long id) {
        return Map.of();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {

    }

    @Override
    public List<Employee> getEmployeesByPosition(String position) {
        return List.of();
    }
}
