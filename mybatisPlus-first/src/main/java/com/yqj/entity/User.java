package com.yqj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: User
 * Author: yaoqijun
 * Date: 2020/8/25 11:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
