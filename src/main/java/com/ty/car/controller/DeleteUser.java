package com.ty.car.controller;

import com.ty.car.dao.UserDao;

public class DeleteUser {

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		boolean result = dao.deleteUser(3);
		System.out.println(result);
	}
}
