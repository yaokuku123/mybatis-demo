package com.yqj.dao;

import com.yqj.pojo.User;

import java.util.List;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: UserMapper
 * Author: yaoqijun
 * Date: 2020/8/20 19:39
 */
public interface UserMapper {
    List<User> selectUsers();
}
