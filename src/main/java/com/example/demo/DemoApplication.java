package com.example.demo;

import com.example.demo.dao.orm.JpaDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        JpaDao jpaDao = (JpaDao)context.getBean("jpaDao");
    }

}
