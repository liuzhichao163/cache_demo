package com.primetion.service;

import com.primetion.enetity.User;

public interface IUserService {
	//��
	User reg(User user);
	//��
	User findUserByName(String username);
	//ɾ
	Integer delete(String username);
	//��
	Integer changeInfo(User user);

}
