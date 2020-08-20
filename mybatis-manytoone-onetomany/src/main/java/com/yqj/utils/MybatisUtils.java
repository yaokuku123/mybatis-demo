package com.yqj.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: MybatisUtils
 * Author: yaoqijun
 * Date: 2020/8/20 19:37
 */
public class MybatisUtils {
    private static SqlSessionFactory sessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }
}
