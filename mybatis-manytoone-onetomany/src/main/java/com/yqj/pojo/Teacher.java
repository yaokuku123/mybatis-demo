package com.yqj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: Teacher
 * Author: yaoqijun
 * Date: 2020/8/20 20:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int id;
    private String name;
    //一个老师多个学生
    private List<Student> students;
}
