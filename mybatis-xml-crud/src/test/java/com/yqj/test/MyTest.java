package com.yqj.test;

import com.yqj.dao.UserMapper;
import com.yqj.pojo.User;
import com.yqj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: MyTest
 * Author: yaoqijun
 * Date: 2020/8/18 20:10
 */
public class MyTest {

    //查询所有
    @Test
    public void testSelectAll(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }

    //根据id查询用户
    @Test
    public void testSelectById(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        System.out.println(user);
        session.close();
    }

    //添加用户
    @Test
    public void testAddUser(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.addUser(new User(4,"tom","123"));
        session.commit();
        session.close();
    }

    //修改用户
    @Test
    public void testUpdateUser(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        user.setName("aliceUpdate");
        mapper.updateUser(user);
        session.commit();
        session.close();
    }

    //删除用户
    @Test
    public void testDeleteUser(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        session.commit();
        session.close();
    }

    //根据用户名和密码查询(传递两个参数)
    @Test
    public void testSelectByNameAndPwd(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectByNameAndPwd("alice", "123456");
        System.out.println(user);
        session.close();
    }

    //根据用户名和密码查询(万能Map)
    @Test
    public void testSelectByMap(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","alice");
        map.put("password","123456");
        User user = mapper.selectByMap(map);
        System.out.println(user);
        session.close();
    }
}
