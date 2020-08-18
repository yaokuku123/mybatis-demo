package com.yqj.dao;

import com.yqj.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: UserMapper
 * Author: yaoqijun
 * Date: 2020/8/18 20:08
 */
public interface UserMapper {
    //查询所有
    List<User> selectUser();

    //根据id查询用户
    User selectById(int id);

    //添加用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

    //根据用户名和密码查询(传递两个参数)
    User selectByNameAndPwd(@Param("name") String name,@Param("pwd") String pwd);

    //根据用户名和密码查询(万能Map)
    User selectByMap(Map<String,Object> map);
}
