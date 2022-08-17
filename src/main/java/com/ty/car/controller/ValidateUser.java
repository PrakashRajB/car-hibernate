package com.ty.car.controller;

import com.ty.car.dao.UserDao;
import com.ty.car.dto.User;

public class ValidateUser {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		User user = dao.validateUser("prakash@gmail.com", "pra1234");
		System.out.println(user);
	}
}
