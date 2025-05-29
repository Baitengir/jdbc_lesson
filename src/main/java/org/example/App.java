package org.example;
import org.example.config.DBConnection;
import org.example.service.EmployeeService;
import org.example.service.JobService;
import org.example.service.serviceImpl.EmployeeServiceImpl;
import org.example.service.serviceImpl.JobServiceImpl;

public class App {

    public static void main( String[] args ) {
//        DBConnection.getConnection();
        JobService jobService = new JobServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();

//        jobService.createJobTable();
        employeeService.createEmployeeTable();
    }

}
