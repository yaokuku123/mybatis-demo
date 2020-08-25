package com.yqj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: MybatisPlusApplication
 * Author: yaoqijun
 * Date: 2020/8/25 11:05
 */
@SpringBootApplication
@MapperScan("com.yqj.mapper")
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class,args);
    }
}
