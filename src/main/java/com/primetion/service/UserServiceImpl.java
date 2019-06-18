package com.primetion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.primetion.dao.IUserDao;
import com.primetion.enetity.User;

@Service("userService")
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	
	@CachePut(value = "UserCache", key="'user:' +#user.username")
	public User reg(User user) {
		userDao.insert(user);
		return user;
	}
	
	@Cacheable(value = "UserCache", key = "'user:' + #username")
	public User findUserByName(String username) {
		System.out.println("执行查询方法");
		return  userDao.findUserByName(username);
	}
	
	@CacheEvict(value="UserCache",key="'user:' +#username") 
	public Integer delete(String username) {
		Integer num = userDao.delete(username);
		return num;
	}
	
	@CachePut(value = "UserCache", key="'user:' +#user.username")
	public Integer changeInfo(User user) {
		Integer id = findUserByName(user.getUsername()).getId();
		System.out.println("id:"+id);
		user.setId(id);
		System.out.println("user:"+user);
		Integer num =userDao.changeInfo(user);
		return num;
	}

}
