package com.demo.web.dao;

import com.demo.web.model.User;
import com.demo.web.model.UserDTO;

import java.util.List;


public interface UserMapper {

    List<User> selectList();

    List<UserDTO> selectListD();
    
    User findById(String idsd);
    
    User findByIds(User user);
    
    int insertUser(User user);
}