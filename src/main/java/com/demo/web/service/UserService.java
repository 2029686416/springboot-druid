package com.demo.web.service;

import java.util.List;
import java.util.Map;

import com.demo.web.model.User;
import com.demo.web.model.UserDTO;

public interface UserService {
	List<User> selectList();
	
	List<UserDTO> selectListD();
	
	User findById(String id);
	
	User findById(User user);
	
	int insertUser(User user);
}
