package com.demo.web.controller;

import com.demo.web.model.User;
import com.demo.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/getList")
	public List<User> getList() {
		List<User> selectList = userService.selectList();
		return selectList;
	}

	@RequestMapping("/user")
	public ModelAndView user(ModelAndView model){
		model.setViewName("user");
		return model;
	}

}
