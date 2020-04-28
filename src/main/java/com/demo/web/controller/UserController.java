package com.demo.web.controller;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.web.model.User;
import com.demo.web.model.UserDTO;
import com.demo.web.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@PropertySource(value = {"classpath:abc.properties"})
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${spring.port}")
	private String port;
	
	@RequestMapping("/testRabbitmq")
	public void testRabbitmq() {
		rabbitTemplate.convertAndSend("test_exc", "abc", "7715");
	}
	
	@RequestMapping("/getList")
	public List<User> getList() {
		System.out.println("port:"+port);
		List<User> selectList = userService.selectList();
		return selectList;
	}
	
	@RequestMapping("/pagehelper")
	public PageInfo<UserDTO> pagehelper(@RequestBody UserDTO user) {
		PageHelper.startPage(user.getPage(), user.getRows());
		List<UserDTO> selectList = userService.selectListD();
		PageInfo<UserDTO> userD = new PageInfo<>(selectList);
		return userD;
	}
	
	@RequestMapping("/find")
	public User find() {
		User selectList = userService.findById("1");
		return selectList;
	}
	
	@RequestMapping("/insertUser")
	public int insertUser(@RequestBody User user) {
		int insertUser = userService.insertUser(user);
		return insertUser;
	}

	@RequestMapping("/user")
	public ModelAndView user(ModelAndView model){
		model.setViewName("user");
		return model;
	}

}
