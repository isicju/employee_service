package com.example.demo.dao;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employees", schema = "hr")
public class EmployeeEntity {


    @Column(name = "first_name")
    private String firstName;


}
