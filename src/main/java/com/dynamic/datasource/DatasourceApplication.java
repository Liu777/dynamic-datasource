package com.dynamic.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.dynamic.datasource.dao")
public class DatasourceApplication {

    public static void main(String[] args) {

        System.out.println("wuxf.cn");
        SpringApplication.run(DatasourceApplication.class, args);
    }

}
