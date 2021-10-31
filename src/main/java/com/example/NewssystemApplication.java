package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.dao"})
@EnableTransactionManagement
public class NewssystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewssystemApplication.class, args);
    }

}
