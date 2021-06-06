package com.example.demo.dao.data;

import com.example.demo.dao.orm.Employees;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employees, Long> {

    public List<Employees> findByFirstName(String firstName);

}
