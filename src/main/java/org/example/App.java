package org.example;
import org.example.models.Employee;
import org.example.models.Job;
import org.example.service.EmployeeService;
import org.example.service.JobService;
import org.example.service.serviceImpl.EmployeeServiceImpl;
import org.example.service.serviceImpl.JobServiceImpl;
import java.util.List;
import java.util.Map;

public class App {

    public static void main( String[] args ) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        JobService jobService = new JobServiceImpl();

        // add job
        Job job1 = new Job(1L, "Manager", "Business Management", "Manages business processes", 5);
        Job job2 = new Job(2L, "Developer", "Software Engineering", "Writes code", 3);
        jobService.addJob(job1);
        jobService.addJob(job2);

        // getJobById
        Job foundJob = jobService.getJobById(1L);
        System.out.println("Found Job: " + foundJob);

        // sortByExperience
        List<Job> sortedJobs = jobService.sortByExperience("desc");
        sortedJobs.forEach(System.out::println);

        // getEmployeeJob
        Job employeeJob = jobService.getJobByEmployeeId(1L);
        System.out.println("Employee's Job: " + employeeJob);

        // todo employees
        try {
        // 1. add employee
//        Employee newEmployee = new Employee();
//        newEmployee.setFirstName("Baitengir");
//        newEmployee.setLastName("Busurman");
//        newEmployee.setAge(18);
//        newEmployee.setEmail("baitengir@gmail.com");
//        newEmployee.setJobId(1);
//        employeeService.addEmployee(newEmployee);

        // 2. getEmployeeById
        Employee foundByEmail = employeeService.getEmployeeByEmail("baitengir@gmail.com");
        System.out.println("Found by email: " + foundByEmail);

        // 3. GetAll
        List<Employee> allEmployees = employeeService.getAllEmployees();
        System.out.println("All employees:");
        allEmployees.forEach(System.out::println);

        // 4. GetAllEmployeesByPosition
        List<Employee> managers = employeeService.getEmployeesByPosition("Manager");
        System.out.println("Managers:");
        managers.forEach(System.out::println);
        // 5. GetAllEmployeeWithHimWork
        Map<Employee, Job> employeeJobMap = employeeService.getEmployeeById(1L);
        employeeJobMap.forEach((employee, job) -> {
            System.out.println("Employee: " + employee);
            System.out.println("Job: " + job);
        });

    } catch (RuntimeException e) {
        System.out.println("error bro " + e.getMessage());
    }
    }

}
