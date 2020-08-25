package com.yqj.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: MybatisPlusConfig
 * Author: yaoqijun
 * Date: 2020/8/25 13:08
 */
@Configuration
@MapperScan("com.yqj.mapper")
public class MybatisPlusConfig {

    //乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    //逻辑删除
    @Bean
    public ISqlInjector iSqlInjector(){
        return new LogicSqlInjector();
    }

    //性能分析
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        //参数：maxTime： SQL 执行最大时长，超过自动停止运行，有助于发现问题
        //参数：format： SQL是否格式化，默认false
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(500);//ms，超过此处设置的ms则sql不执行
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

}
