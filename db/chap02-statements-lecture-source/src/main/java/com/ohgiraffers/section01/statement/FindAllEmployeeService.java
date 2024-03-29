package com.ohgiraffers.section01.statement;

import com.ohgiraffers.domain.entity.Employee;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class FindAllEmployeeService {


    public List<Employee> findAllEmployees(String desc){

        Connection con = getConnection();

        EmployeeRepositoy repositoy = new EmployeeRepositoy();

        List<Employee> employees = repositoy.findAllEmployees(con);

        close(con);
        return employees;

    }


    public List<Employee> findAllEmployees(){

        Connection con = getConnection();

        EmployeeRepositoy repositoy = new EmployeeRepositoy();

        List<Employee> employees = repositoy.findAllEmployees(con);

        close(con);
        return employees;

    }


}
