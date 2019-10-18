package com.demo.web.service;

import java.util.List;
import java.util.Map;

import com.demo.web.model.User;

public interface UserService {
	List<User> selectList();
	
	User findById(String id);
	
	User findById(User user);
}
