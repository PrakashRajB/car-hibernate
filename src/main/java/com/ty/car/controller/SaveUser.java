package com.ty.car.controller;

import com.ty.car.dao.UserDao;
import com.ty.car.dto.User;
import com.ty.car.helper.AES;

public class SaveUser {
	public static void main(String[] args) {
		
		User user=new User();
		user.setName("Gokul");
		user.setEmail("gokul@gmail.com");
		user.setPassword(AES.encrypt("gokul1234"));
		
		UserDao dao=new UserDao();
		dao.saveUser(user);
		
	}

}
