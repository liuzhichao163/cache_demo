package com.primetion.service;

import com.primetion.enetity.User;

public interface IUserService {
	//Ôö
	User reg(User user);
	//²é
	User findUserByName(String username);
	//É¾
	Integer delete(String username);
	//¸Ä
	Integer changeInfo(User user);

}
