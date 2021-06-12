package com.example.demo;

import com.example.demo.dao.Employee;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.data.CountryRepository;
import com.example.demo.dao.data.EmployeeRepository;
import com.example.demo.dao.orm.Countries;
import com.example.demo.dao.orm.Employees;
import com.example.demo.dao.orm.JpaDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        EmployeeRepository employeeRepository = (EmployeeRepository) context.getBean("employeeRepository");
        CountryRepository countryRepository = (CountryRepository) context.getBean("countryRepository");
//        JpaDao jpaDao =   (JpaDao)context.getBean("jpaDao");
        Iterator<Employees> iterator = employeeRepository.findAll().iterator();
        iterator.forEachRemaining(each -> {
            System.out.println(each);
        });

        Countries countries = new Countries();
        countries.setCountryId("F7");
        countries.setCountryName("F7 land");
        countries.setRegionId(4);

        countryRepository.save(countries);

        System.out.println("new country found by id: " + countryRepository.findById("F7").get());


        //        System.out.println("number of records: " + jpaDao.findAll().size());
//        System.out.println(jpaDao.findById());

//        UserRepository userRepository = (UserRepository)context.getBean("userRepository");
//        List<Countries> employeeList = jpaDao.findAll();
//
//        employeeList.forEach(employee -> {
//            System.out.println(employee);
//        });

//        Countries countries = new Countries();
//        countries.setCountryId("F4");
//        countries.setCountryName("F4 land");
//        countries.setRegionId(4);
//
//        jpaDao.addNewCountry(countries);

    }

}
