package com.yqj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: User
 * Author: yaoqijun
 * Date: 2020/8/24 19:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;
}
