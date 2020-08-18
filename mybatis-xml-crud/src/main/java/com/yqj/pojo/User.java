package com.yqj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: User
 * Author: yaoqijun
 * Date: 2020/8/18 20:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;  //id
    private String name;   //姓名
    private String pwd;   //密码
}
