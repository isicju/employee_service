package com.example.demo.dao.template;

import com.example.demo.dao.jdbc.Employee;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class EmployeeTemplate {

    JdbcTemplate jdbcTemplate;

    public List<Employee> getEmployees(){
       List<Map<String,Object>> employeeRawMap =  jdbcTemplate.queryForList("Select * from hr.employees");
       List<Employee> employees = new ArrayList<>();
        for (Map<String, Object> country : employeeRawMap) {
            String firstName = (String)country.get("first_name");
            String lastName = (String)country.get("last_name");
            Integer salary = ((BigDecimal) country.get("salary")).intValue();
            employees.add(Employee.builder().firstName(firstName).lastName(lastName).salary(salary).build());
        }
        return employees;
    }



}
