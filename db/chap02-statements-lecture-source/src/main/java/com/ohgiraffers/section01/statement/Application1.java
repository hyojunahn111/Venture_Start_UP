package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {

        Connection con = getConnection();

        /*Statement : 쿼리문을 저장하고 실행하는 기능을 하는 용도의 인터페이스*/
        Statement stmt = null;
        /*ResultSet : */
        ResultSet rset = null;


        try {

            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");      //쿼리를 저장해서 db에 날려주고 rset에 반환함

            while(rset.next()){  //반환된 값을 받아서 하나씩 반복해서 정보를 출력함
                System.out.println(
                        rset.getString("EMP_ID")        //꺼내올 때 get자료형을 이용했다   *db는 자동형변환이 잘 되서 만약 int로 출력하려하고 하면 int 값으로 자동형변환되서 출력 할 수도 있음
                        + ", "
                        + rset.getString("EMP_NAME")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            {
                close(rset);
                close(stmt);
                close(con);
            }
        }
    }

}
