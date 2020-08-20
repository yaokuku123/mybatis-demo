package com.yqj.dao;

import com.yqj.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: UserMapper
 * Author: yaoqijun
 * Date: 2020/8/20 20:21
 */
public interface UserMapper {

    //查询所有
    @Select("select * from user")
    List<User> selectUsers();

    //按id查询
    @Select("select * from user where id=#{id}")
    User selectById(@Param("id") int id);

    //添加
    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{pwd})")
    int addUser(User user);

    //修改
    @Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
    int updateUser(User user);

    //删除
    @Delete("delete from user where id=#{id}")
    int deleteUser(@Param("id") int id);
}
