package com.ohgiraffers.section01.statement;

import com.ohgiraffers.domain.entity.Employee;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class FindOneEmployeeService {

    public Employee findEmployeeByEmpId(String empId){

        Connection con = getConnection();

        EmployeeRepositoy repositoy = new EmployeeRepositoy();

        Employee foundEmployee = repositoy.findEmployeeByEmpId(con, empId);

        close(con);

        return foundEmployee;

    }
}
