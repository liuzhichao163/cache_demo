package com.primetion.dao;

import com.primetion.enetity.User;

public interface IUserDao {
	//Ôö
	Integer insert(User user);
	//É¾
	Integer delete(String username);
	//²é
	User findUserByName(String username);
	//¸Ä
	Integer changeInfo(User user);

}
