package com.yqj.dao;

import com.yqj.pojo.User;

import java.util.List;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: UserMapper
 * Author: yaoqijun
 * Date: 2020/8/18 20:08
 */
public interface UserMapper {
    List<User> selectUser();
}
