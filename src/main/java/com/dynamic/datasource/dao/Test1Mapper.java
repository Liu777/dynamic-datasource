package com.dynamic.datasource.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description: datasource
 * @EnglishName LuKe
 * @authod LiuQi
 * @date 2019/6/27 17:56
 */
@Repository
@Mapper
public interface Test1Mapper {

    @Select("select * from user")
    List<Map<String, Object>> findAll();

}
