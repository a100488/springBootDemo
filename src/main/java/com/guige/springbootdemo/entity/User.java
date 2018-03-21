package com.guige.springbootdemo.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
@Data
public class User {

    private Integer id;
    
    private String username;
    
    private String password;
    @JSONField(format="yyyy-MM-dd")
    private Date birthday;

    

}