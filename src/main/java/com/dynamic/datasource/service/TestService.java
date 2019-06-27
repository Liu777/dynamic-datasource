package com.dynamic.datasource.service;

import com.dynamic.datasource.dao.Test1Mapper;
import com.dynamic.datasource.dao.Test2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Description: datasource
 * @EnglishName LuKe
 * @authod LiuQi
 * @date 2019/6/27 18:03
 */
@Service
public class TestService {

    @Autowired
    private Test1Mapper test1Mapper;
    @Autowired
    private Test2Mapper test2Mapper;


    public List<Map<String, Object>> findTest1() {

        return test1Mapper.findAll();
    }

    @DataSource(DataSourceEnum.TEST2)
    public List<Map<String, Object>> findTest2() {

        return test2Mapper.findAll();
    }

    /**
     * 如果切面不加@Order，添加Transactional注解会导致切换数据源失效
     */
    @Transactional
    @DataSource(DataSourceEnum.TEST2)
    public void insert() {
        test2Mapper.insert();
        int i = 1 / 0;
    }
}
