package com.example.demo;

import com.example.demo.dao.Employee;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.orm.Countries;
import com.example.demo.dao.orm.Employees;
import com.example.demo.dao.orm.JpaDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        JpaDao jpaDao =   (JpaDao)context.getBean("jpaDao");
//        System.out.println("number of records: " + jpaDao.findAll().size());
//        System.out.println(jpaDao.findById());

//        UserRepository userRepository = (UserRepository)context.getBean("userRepository");
        List<Countries> employeeList = jpaDao.findAll();

        employeeList.forEach(employee -> {
            System.out.println(employee);
        });
    }

}
