package com.primetion.dao;

import com.primetion.enetity.User;

public interface IUserDao {
	//��
	Integer insert(User user);
	//ɾ
	Integer delete(String username);
	//��
	User findUserByName(String username);
	//��
	Integer changeInfo(User user);

}
