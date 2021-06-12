package com.example.demo.dao.data;

import com.example.demo.dao.orm.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employees, Long> {


}
