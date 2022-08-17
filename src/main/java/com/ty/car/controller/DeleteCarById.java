package com.ty.car.controller;

import com.ty.car.dao.CarDao;

public class DeleteCarById {
	public static void main(String[] args) {

		CarDao carDao = new CarDao();
		boolean result = carDao.deleteCarById(1);
		System.out.println(result);
	}

}
