package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UseEmployee {

	public static void main(String[] args) {
        // Sample list of employees
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "Engineering", 1000.0),
            new Employee("Bob", "Engineering", 1200.0),
            new Employee("Charlie", "HR", 900.0),
            new Employee("David", "HR", 850.0),
            new Employee("Eve", "Finance", 1100.0)
        );

        // Calculate total salary by department using streams
        Map<String, Double> salaryByDepartment = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,                        // Group by department
                Collectors.summingDouble(Employee::getSalary)   // Sum salaries in each department
            ));
        
        Map<String, List<Employee>> namesByDepartment = employees.stream()
        	    .collect(Collectors.groupingBy(
        	        Employee::getDepartment,
        	        Collectors.mapping(z->z, Collectors.toList())
        	    ));
//        		namesByDepartment.forEach((a,b)->{System.out.println(a+":"+b);});
        System.out.println(namesByDepartment);
        // Print the result
        salaryByDepartment.forEach((department, totalSalary) -> 
            System.out.println("Department: " + department + ", Total Salary: " + totalSalary));
        
        IntStream.range(1, 2000).filter(a->a%7==0).forEach(System.out::println);
    }
}
