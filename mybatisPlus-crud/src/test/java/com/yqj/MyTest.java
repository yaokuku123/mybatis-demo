package com.yqj;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yqj.entity.User;
import com.yqj.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: MyTest
 * Author: yaoqijun
 * Date: 2020/8/25 11:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private UserMapper userMapper;

    //插入用户数据
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("yorick");
        user.setAge(20);
        user.setEmail("yorick@qq.com");
        int result = userMapper.insert(user);
        System.out.println(result);
    }

    //更新用户数据
    @Test
    public void testUpdate(){
        User user = userMapper.selectById(1L);
        user.setName("alice2");
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    //查询全部用户
    @Test
    public void testSelectList(){
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    //根据id查询
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    //多个id批量查询
    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        for (User user : users) {
            System.out.println(user);
        }
    }

    //map封装的条件查询
    @Test
    public void testSelctByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","yorick");
        map.put("age",18);
        List<User> users = userMapper.selectByMap(map);
        for (User user : users) {
            System.out.println(user);
        }
    }

    //分页查询
    @Test
    public void testSelectPage(){
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println); //当前页的数据
        System.out.println(page.getCurrent()); //当前页
        System.out.println(page.getPages()); //总页数
        System.out.println(page.getSize()); //每页显示的数据条目
        System.out.println(page.getTotal()); //总共的数据条目
        System.out.println(page.hasNext()); //是否有下一页
        System.out.println(page.hasPrevious()); //是否有上一页
    }

    //根据id删除
    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(4L);
        System.out.println(result);
    }

    //复杂查询
    @Test
    public void testComplexSelect(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //ge,gt,le,lt,isNull,isNotNull
        //查询年龄不小于20岁的用户
        //wrapper.ge("age",20);

        //eq,ne
        //查询姓名为yorick的用户
        //wrapper.eq("name","yorick");

        //between,notBetween
        //查询年龄在20~30之间的用户，包含20和30边界
        //wrapper.between("age",20,30);

        //like
        //查询姓名包含yorick的用户
        //wrapper.like("name","yorick");

        //orderByDesc,orderByAsc
        //按id降序排序
        //wrapper.orderByDesc("id");

        //last 直接拼接sql到最后，有sql注入风险
        //wrapper.last("limit 1");

        //指定要查找的列
        wrapper.select("id","name");


        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
