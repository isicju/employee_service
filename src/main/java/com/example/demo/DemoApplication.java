package com.example.demo;

import com.example.demo.dao.Employee;
import com.example.demo.dao.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        UserRepository userRepository = (UserRepository)context.getBean("userRepository");

        List<Employee> employeeList = userRepository.getEmployeesTemplate();

        employeeList.forEach(employee -> {
            System.out.print(employee.getFirstName());
            System.out.print(employee.getLastName());
            System.out.println(employee.getSalary());
        });
    }

}
