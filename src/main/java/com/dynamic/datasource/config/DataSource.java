package com.dynamic.datasource.config;

import java.lang.annotation.*;

/**
 * 数据源
 * @Description: datasource
 * @EnglishName LuKe
 * @authod LiuQi
 * @date 2019/6/27 18:09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSource {

    //枚举
    DataSourceEnum value();
}
