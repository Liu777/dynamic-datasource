package com.dynamic.datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * @Description: datasource
 * @EnglishName LuKe
 * @authod LiuQi
 * @date 2019/6/27 18:50
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {

        //基于aop切换数据源
        System.out.println("dynamic datasource 切换数据源" + DataSourceHolder.getDataSource());
        return DataSourceHolder.getDataSource();
    }
}
