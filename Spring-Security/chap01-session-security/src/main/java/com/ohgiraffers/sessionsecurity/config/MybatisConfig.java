package com.ohgiraffers.sessionsecurity.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ohgiraffers.sessionsecurity")
public class MybatisConfig {
}
