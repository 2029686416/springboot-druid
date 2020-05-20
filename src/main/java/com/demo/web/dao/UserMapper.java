package com.demo.web.dao;

import java.util.List;
import java.util.Map;

import com.demo.web.model.User;
import com.demo.web.model.UserDTO;


public interface UserMapper {

    List<User> selectList();

    List<Map<String, Object>> selectMenuList();
    
    List<UserDTO> selectListD();
    
    User findById(String idsd);
    
    User findByIds(User user);
    
    int insertUser(User user);
}