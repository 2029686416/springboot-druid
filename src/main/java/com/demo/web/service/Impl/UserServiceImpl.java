package com.demo.web.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.web.dao.UserMapper;
import com.demo.web.model.User;
import com.demo.web.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> selectList() {
		// TODO Auto-generated method stub
		return userMapper.selectList();
	}

	@Override
	public User findById(String idab) {
		// TODO Auto-generated method stub
		return userMapper.findById(idab);
	}

	@Override
	public User findById(User user) {
		// TODO Auto-generated method stub
		return userMapper.findByIds(user);
	}
}
