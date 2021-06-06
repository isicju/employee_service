package com.example.demo;

import com.example.demo.dao.orm.Countries;
import com.example.demo.dao.orm.JpaDao;
import com.example.demo.dao.template.EmployeeTemplate;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Log4j2
@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        //JdbcTemplate - wrapper on top of jdbc
        checkJdbcTemplate(context);

        //Using Jpa Hibernate style
        checkJpaHibernate(context);

    }

    private static void checkJdbcTemplate(ApplicationContext context){
        EmployeeTemplate employeeTemplate = (EmployeeTemplate) context.getBean("employeeTemplate");
        employeeTemplate.getEmployees();
    }

    private static void checkJpaHibernate(ApplicationContext context) {
        //Jpa Hibernate similar
        JpaDao jpaDao = (JpaDao) context.getBean("jpaDao");
        jpaDao.getCountryByName("Argentina");

        Countries disneyLandCountry = new Countries();
        disneyLandCountry.setRegionId(2);
        disneyLandCountry.setCountryName("Disney Land");
        disneyLandCountry.setCountryId("DL");

        jpaDao.addNewCountry(disneyLandCountry);

        Countries recentlyAddedCountry = jpaDao.findAll().stream()
                .filter(country -> country.getCountryId().equals("DL"))
                .findFirst().get();
        log.info("Among all countries there is added one! " + recentlyAddedCountry);

        jpaDao.removeCountry(disneyLandCountry);

        long count = jpaDao.findAll().stream()
                .filter(country -> country.getCountryId().equals("DL"))
                .count();
        log.info("After removing number of countries with DL id " + count);
    }

}
