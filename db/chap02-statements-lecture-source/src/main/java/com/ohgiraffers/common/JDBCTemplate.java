package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection(){

        Connection con = null;
        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));

            String driver = prop.getProperty("driver");     //드라이버 정보랑 url을 환경변수에서 받아봄
            String url = prop.getProperty("url");

            Class.forName(driver);         //드라이버에 해당하는 클래스를 메모리에 할당한다

            con = DriverManager.getConnection(url, prop);  //직접 instance 생성이 불가능함으로 Drivermanager를 사용해서 instatnce를 생성함

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) { //찾지 못할 경우 예외처리
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;

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
