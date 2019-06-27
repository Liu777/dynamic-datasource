package com.dynamic.datasource.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 数据源枚举
 * @Description: datasource
 * @EnglishName LuKe
 * @authod LiuQi
 * @date 2019/6/27 18:11
 */
@AllArgsConstructor
@Getter
public enum DataSourceEnum {

    DEFAULT("test1"),
    TEST1("test1"),
    TEST2("test2");
    private String name;
}
