package com.yqj.dao;

import com.yqj.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: UserMapper
 * Author: yaoqijun
 * Date: 2020/8/24 19:57
 */
public interface UserMapper {

    //根据姓名和密码动态筛选用户
    List<User> selectUserByNameAndPwd(Map map);

    //更新用户，动态更改姓名和密码
    int updateUser(User user);

    //查找多个指定id的用户
    List<User> selectUsers(Map map);
}
