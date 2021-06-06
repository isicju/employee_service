package com.example.demo.dao.jooq;

import com.example.demo.dao.jooq.tables.records.EmployeesRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.codegen.GenerationTool;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.example.demo.dao.jooq.Tables.DEPARTMENTS;
import static com.example.demo.dao.jooq.Tables.EMPLOYEES;


public class Generator {
    public static void main(String[] args) throws Exception {
        String userName = "root";
        String password = "secret_password";
        String url = "jdbc:mysql://51.124.98.77:3306/hr";
        Connection conn = DriverManager.getConnection(url, userName, password);
        DSLContext context = DSL.using(conn, SQLDialect.MYSQL);


        Result<EmployeesRecord> employees = context
                .selectFrom(EMPLOYEES)
                .fetch();

        for (EmployeesRecord employee: employees){
            System.out.println("first name: " + employee.getFirstName());
            System.out.println("salary: " + employee.getSalary());
            System.out.println("email: " + employee.getEmail());
        }

        Result<Record> employeeDetails =  context.select().from(EMPLOYEES)
                .innerJoin(Tables.DEPARTMENTS).on(EMPLOYEES.DEPARTMENT_ID.eq(DEPARTMENTS.DEPARTMENT_ID))
                .fetch();

        for (Record employeeDetail : employeeDetails){
            System.out.println("employee name: " + employeeDetail.get(EMPLOYEES.FIRST_NAME));
            System.out.println("employee department name: " + employeeDetail.get(DEPARTMENTS.DEPARTMENT_NAME));
        }



    }

    private static void generate() throws Exception {
        GenerationTool.generate(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<configuration xmlns=\"http://www.jooq.org/xsd/jooq-codegen-3.13.0.xsd\">\n" +
                        "\n" +
                        "    <jdbc>\n" +
                        "        <driver>com.mysql.jdbc.Driver</driver>\n" +
                        "        <url>jdbc:mysql://51.124.98.77:3306/hr</url>\n" +
                        "        <user>root</user>\n" +
                        "        <password>secret_password</password>\n" +
                        "    </jdbc>\n" +
                        "\n" +
                        "    <generator>\n" +
                        "        <name>org.jooq.codegen.JavaGenerator</name>\n" +
                        "\n" +
                        "        <database>\n" +
                        "            <name>org.jooq.meta.mysql.MySQLDatabase</name>\n" +
                        "            <inputSchema>hr</inputSchema>\n" +
                        "            <includes>.*</includes>\n" +
                        "            <excludes></excludes>\n" +
                        "        </database>\n" +
                        "\n" +
                        "        <target>\n" +
                        "            <packageName>com.example.demo.dao.jooq</packageName>\n" +
                        "            <directory>C:\\Users\\isicj\\projects\\employee_service\\src\\main\\java\\com\\example\\demo\\dao\\jooq</directory>\n" +
                        "        </target>\n" +
                        "    </generator>\n" +
                        "</configuration>"
        );
    }
}
