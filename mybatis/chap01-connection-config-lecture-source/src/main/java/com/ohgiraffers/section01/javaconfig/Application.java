package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {

    /*DB connection 정보를 static 필드로 선언*/
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menu";
    private static String USER = "sahmyook";
    private static String PASSWORD = "sahmyook";

    public static void main(String[] args) {

        Environment environment = new Environment("dev", new JdbcTransactionFactory(), new PooledDataSource(DRIVER, URL, USER, PASSWORD));

        Configuration configuration = new Configuration(environment);

        configuration.addMapper(Mapper.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        //여기까지가 db connection 생성

    }
}
