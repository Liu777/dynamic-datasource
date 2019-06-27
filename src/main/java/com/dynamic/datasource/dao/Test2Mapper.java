package com.dynamic.datasource.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description: datasource
 * @EnglishName LuKe
 * @authod LiuQi
 * @date 2019/6/27 18:06
 */
@Repository
@Mapper
public interface Test2Mapper {

    @Select("select * from product")
    List<Map<String, Object>> findAll();

    @Insert("insert into product(number) values(2)")
    int insert();

}
