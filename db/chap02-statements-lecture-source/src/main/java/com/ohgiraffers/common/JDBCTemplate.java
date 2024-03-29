package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection(){

        Connection con = null;
        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void close(Connection con){

        try {
            if(con != null && !con.isClosed()){

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
