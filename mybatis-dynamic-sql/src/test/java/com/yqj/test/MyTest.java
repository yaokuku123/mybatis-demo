package com.yqj.test;

import com.yqj.dao.UserMapper;
import com.yqj.pojo.User;
import com.yqj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: MyTest
 * Author: yaoqijun
 * Date: 2020/8/24 19:59
 */
public class MyTest {

    //根据姓名和密码动态筛选用户
    @Test
    public void testSelectUserByNameAndPwd(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("name","jerry");
        map.put("pwd","123");
        List<User> users = mapper.selectUserByNameAndPwd(map);
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }

    //更新用户，动态更改姓名和密码
    @Test
    public void testUpdateUser(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(2);
        user.setName("ketty");
        user.setPwd("233");
        mapper.updateUser(user);
        session.commit();
        session.close();
    }

    //查找多个指定id的用户
    @Test
    public void testSelectUsers(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        map.put("ids",ids);
        List<User> users = mapper.selectUsers(map);
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }
}
