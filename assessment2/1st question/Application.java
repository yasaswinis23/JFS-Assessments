package com.example.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        EmployeeManager employeeManager = context.getBean(EmployeeManager.class);

        // Add a new employee
        Employee emp1 = new Employee();
        emp1.setName("John Doe");
        emp1.setDepartment("IT");
        employeeManager.addEmployee(emp1);

        // Get all employees
        System.out.println("All Employees: " + employeeManager.getAllEmployees());

        // Get employee by id
        Employee emp = employeeManager.getEmployeeById(1);
        System.out.println("Employee with ID 1: " + emp);

        // Update employee
        if (emp != null) {
            emp.setDepartment("HR");
            employeeManager.updateEmployee(emp);
            System.out.println("Updated Employee with ID 1: " + employeeManager.getEmployeeById(1));
        }

        // Delete employee
        employeeManager.deleteEmployee(1);
        System.out.println("All Employees after deletion: " + employeeManager.getAllEmployees());

        context.close();
	}

}
