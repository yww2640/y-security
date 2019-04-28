package com.slightlee.yadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.slightlee.yadmin.*.mapper"})
public class YAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(YAdminApplication.class, args);
    }

}
