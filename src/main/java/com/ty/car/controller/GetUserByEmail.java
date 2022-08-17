package com.ty.car.controller;

import com.ty.car.dao.UserDao;
import com.ty.car.dto.User;
import com.ty.car.helper.AES;

public class GetUserByEmail {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		User user = dao.getUserByEmail("gokul@gmail.com");
		System.out.println(AES.decrypt(user.getPassword()));
	}

}
