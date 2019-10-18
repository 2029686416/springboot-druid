package com.demo.web.dao;

import com.demo.web.model.User;

import java.util.List;


public interface UserMapper {

    List<User> selectList();
    
    User findById(String idsd);
    
    User findByIds(User user);
}