package com.dynamic.datasource.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Asepct
 *
 * @Description: datasource
 * @EnglishName LuKe
 * @authod LiuQi
 * @date 2019/6/27 18:23
 */
@Aspect
@Component
@Order(1)
public class DataSourceAsepct {

    //加载数据源
    @Pointcut("@annotation(com.dynamic.datasource.config.DataSource)")
    public void pointCut(){ }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        DataSourceEnum dataSource = DataSourceEnum.DEFAULT;
        try {
            Method method = target.getClass().getMethod(signature.getName(), signature.getParameterTypes());
            if (method.isAnnotationPresent(DataSource.class)) {
                DataSource annotation = method.getAnnotation(DataSource.class);
                dataSource = annotation.value();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //实现aop切换数据源
        System.out.println("aop切换数据源：" + dataSource.getName());
        DataSourceHolder.setDataSource(dataSource);
    }

    @After("pointCut()")
    public void after() {

        DataSourceHolder.clearDataSource();
    }
}
