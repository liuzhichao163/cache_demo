package com.primetion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primetion.enetity.User;
import com.primetion.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/insert.do",method=RequestMethod.POST)
	@ResponseBody
	public void insert(@RequestParam("username") String username,@RequestParam("password") String password,String email,String phone,Integer gender) {
		User user = new User(username,password,gender,phone,email);
		//调用业务层的reg()方法实现注册功能
		System.out.println("执行新增方法");
		userService.reg(user);
	}
	
	@RequestMapping(value="/delete.do",method=RequestMethod.POST)
	@ResponseBody
	public Integer delete(@RequestParam("username") String username) {
		Integer num = userService.delete(username);
		return num;
	}
	
	
	@RequestMapping(value="/getuser.do",method=RequestMethod.POST)
	@ResponseBody
	public User select(@RequestParam("username") String username) {
		
		return userService.findUserByName(username);
	}
	
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	@ResponseBody
	public Integer update(@RequestParam("username") String username,@RequestParam("password") String password,String email,String phone,Integer gender) {
		User user = new User(username,password,gender,phone,email);
		Integer num = userService.changeInfo(user);
		return num;
	}
	

}
