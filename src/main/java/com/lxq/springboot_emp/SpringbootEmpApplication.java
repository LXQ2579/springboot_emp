package com.lxq.springboot_emp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//扫描dao层注解
@MapperScan("com.lxq.springboot_emp.dao")
public class SpringbootEmpApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootEmpApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringbootEmpApplication.class, args);
    }

}
