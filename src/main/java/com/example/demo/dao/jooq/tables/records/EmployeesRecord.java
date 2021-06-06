/*
 * This file is generated by jOOQ.
 */
package com.example.demo.dao.jooq.tables.records;


import com.example.demo.dao.jooq.tables.Employees;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;

import java.math.BigDecimal;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EmployeesRecord extends UpdatableRecordImpl<EmployeesRecord> implements Record11<UInteger, String, String, String, String, String, String, BigDecimal, BigDecimal, UInteger, UInteger> {

    private static final long serialVersionUID = -1490141603;

    /**
     * Setter for <code>hr.employees.employee_id</code>.
     */
    public void setEmployeeId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>hr.employees.employee_id</code>.
     */
    public UInteger getEmployeeId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>hr.employees.first_name</code>.
     */
    public void setFirstName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>hr.employees.first_name</code>.
     */
    public String getFirstName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>hr.employees.last_name</code>.
     */
    public void setLastName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>hr.employees.last_name</code>.
     */
    public String getLastName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>hr.employees.email</code>.
     */
    public void setEmail(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>hr.employees.email</code>.
     */
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>hr.employees.phone_number</code>.
     */
    public void setPhoneNumber(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>hr.employees.phone_number</code>.
     */
    public String getPhoneNumber() {
        return (String) get(4);
    }

    /**
     * Setter for <code>hr.employees.hire_date</code>.
     */
    public void setHireDate(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>hr.employees.hire_date</code>.
     */
    public String getHireDate() {
        return (String) get(5);
    }

    /**
     * Setter for <code>hr.employees.job_id</code>.
     */
    public void setJobId(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>hr.employees.job_id</code>.
     */
    public String getJobId() {
        return (String) get(6);
    }

    /**
     * Setter for <code>hr.employees.salary</code>.
     */
    public void setSalary(BigDecimal value) {
        set(7, value);
    }

    /**
     * Getter for <code>hr.employees.salary</code>.
     */
    public BigDecimal getSalary() {
        return (BigDecimal) get(7);
    }

    /**
     * Setter for <code>hr.employees.commission_pct</code>.
     */
    public void setCommissionPct(BigDecimal value) {
        set(8, value);
    }

    /**
     * Getter for <code>hr.employees.commission_pct</code>.
     */
    public BigDecimal getCommissionPct() {
        return (BigDecimal) get(8);
    }

    /**
     * Setter for <code>hr.employees.manager_id</code>.
     */
    public void setManagerId(UInteger value) {
        set(9, value);
    }

    /**
     * Getter for <code>hr.employees.manager_id</code>.
     */
    public UInteger getManagerId() {
        return (UInteger) get(9);
    }

    /**
     * Setter for <code>hr.employees.department_id</code>.
     */
    public void setDepartmentId(UInteger value) {
        set(10, value);
    }

    /**
     * Getter for <code>hr.employees.department_id</code>.
     */
    public UInteger getDepartmentId() {
        return (UInteger) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<UInteger, String, String, String, String, String, String, BigDecimal, BigDecimal, UInteger, UInteger> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<UInteger, String, String, String, String, String, String, BigDecimal, BigDecimal, UInteger, UInteger> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<UInteger> field1() {
        return Employees.EMPLOYEES.EMPLOYEE_ID;
    }

    @Override
    public Field<String> field2() {
        return Employees.EMPLOYEES.FIRST_NAME;
    }

    @Override
    public Field<String> field3() {
        return Employees.EMPLOYEES.LAST_NAME;
    }

    @Override
    public Field<String> field4() {
        return Employees.EMPLOYEES.EMAIL;
    }

    @Override
    public Field<String> field5() {
        return Employees.EMPLOYEES.PHONE_NUMBER;
    }

    @Override
    public Field<String> field6() {
        return Employees.EMPLOYEES.HIRE_DATE;
    }

    @Override
    public Field<String> field7() {
        return Employees.EMPLOYEES.JOB_ID;
    }

    @Override
    public Field<BigDecimal> field8() {
        return Employees.EMPLOYEES.SALARY;
    }

    @Override
    public Field<BigDecimal> field9() {
        return Employees.EMPLOYEES.COMMISSION_PCT;
    }

    @Override
    public Field<UInteger> field10() {
        return Employees.EMPLOYEES.MANAGER_ID;
    }

    @Override
    public Field<UInteger> field11() {
        return Employees.EMPLOYEES.DEPARTMENT_ID;
    }

    @Override
    public UInteger component1() {
        return getEmployeeId();
    }

    @Override
    public String component2() {
        return getFirstName();
    }

    @Override
    public String component3() {
        return getLastName();
    }

    @Override
    public String component4() {
        return getEmail();
    }

    @Override
    public String component5() {
        return getPhoneNumber();
    }

    @Override
    public String component6() {
        return getHireDate();
    }

    @Override
    public String component7() {
        return getJobId();
    }

    @Override
    public BigDecimal component8() {
        return getSalary();
    }

    @Override
    public BigDecimal component9() {
        return getCommissionPct();
    }

    @Override
    public UInteger component10() {
        return getManagerId();
    }

    @Override
    public UInteger component11() {
        return getDepartmentId();
    }

    @Override
    public UInteger value1() {
        return getEmployeeId();
    }

    @Override
    public String value2() {
        return getFirstName();
    }

    @Override
    public String value3() {
        return getLastName();
    }

    @Override
    public String value4() {
        return getEmail();
    }

    @Override
    public String value5() {
        return getPhoneNumber();
    }

    @Override
    public String value6() {
        return getHireDate();
    }

    @Override
    public String value7() {
        return getJobId();
    }

    @Override
    public BigDecimal value8() {
        return getSalary();
    }

    @Override
    public BigDecimal value9() {
        return getCommissionPct();
    }

    @Override
    public UInteger value10() {
        return getManagerId();
    }

    @Override
    public UInteger value11() {
        return getDepartmentId();
    }

    @Override
    public EmployeesRecord value1(UInteger value) {
        setEmployeeId(value);
        return this;
    }

    @Override
    public EmployeesRecord value2(String value) {
        setFirstName(value);
        return this;
    }

    @Override
    public EmployeesRecord value3(String value) {
        setLastName(value);
        return this;
    }

    @Override
    public EmployeesRecord value4(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public EmployeesRecord value5(String value) {
        setPhoneNumber(value);
        return this;
    }

    @Override
    public EmployeesRecord value6(String value) {
        setHireDate(value);
        return this;
    }

    @Override
    public EmployeesRecord value7(String value) {
        setJobId(value);
        return this;
    }

    @Override
    public EmployeesRecord value8(BigDecimal value) {
        setSalary(value);
        return this;
    }

    @Override
    public EmployeesRecord value9(BigDecimal value) {
        setCommissionPct(value);
        return this;
    }

    @Override
    public EmployeesRecord value10(UInteger value) {
        setManagerId(value);
        return this;
    }

    @Override
    public EmployeesRecord value11(UInteger value) {
        setDepartmentId(value);
        return this;
    }

    @Override
    public EmployeesRecord values(UInteger value1, String value2, String value3, String value4, String value5, String value6, String value7, BigDecimal value8, BigDecimal value9, UInteger value10, UInteger value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EmployeesRecord
     */
    public EmployeesRecord() {
        super(Employees.EMPLOYEES);
    }

    /**
     * Create a detached, initialised EmployeesRecord
     */
    public EmployeesRecord(UInteger employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobId, BigDecimal salary, BigDecimal commissionPct, UInteger managerId, UInteger departmentId) {
        super(Employees.EMPLOYEES);

        set(0, employeeId);
        set(1, firstName);
        set(2, lastName);
        set(3, email);
        set(4, phoneNumber);
        set(5, hireDate);
        set(6, jobId);
        set(7, salary);
        set(8, commissionPct);
        set(9, managerId);
        set(10, departmentId);
    }
}
