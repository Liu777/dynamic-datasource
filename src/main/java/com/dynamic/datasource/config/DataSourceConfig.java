package com.dynamic.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建数据源，连接数据库db
 *
 * @Description: datasource
 * @EnglishName LuKe
 * @authod LiuQi
 * @date 2019/6/27 18:45
 */
@Configuration
public class DataSourceConfig {

    //连接数据库db1
    @Bean("test1Db")
    @ConfigurationProperties("spring.datasource.test1")
    public DataSource test1Db() {

        return new DruidDataSource();
    }

    //连接数据库db2
    @Bean("test2Db")
    @ConfigurationProperties("spring.datasource.test2")
    public DataSource test2Db() {

        return new DruidDataSource();
    }

    @Bean("dynamicDataSource")
    @Primary
    public DataSource dynamicDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setDefaultTargetDataSource(test1Db());
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put(DataSourceEnum.TEST1.getName(), test1Db());
        dataSourceMap.put(DataSourceEnum.TEST2.getName(), test2Db());
        dataSource.setTargetDataSources(dataSourceMap);
        return dataSource                                                                                                               ;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
