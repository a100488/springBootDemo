package com.guige.springbootdemo.dao;

import com.guige.springbootdemo.entity.User;

public interface UserDao {

    public int insert(User user);
    
    public int deleteById(Integer id);
    
    public int update(User user);
    
    public User getById(Integer id);
}
