package com.ty.car.controller;

import com.ty.car.dao.CarDao;

public class UpdateCarById {
	public static void main(String[] args) {
		CarDao carDao = new CarDao();
		boolean result = carDao.updateCarById(3);
		if (result) {
			System.out.println("Data Updated");
		} else {
			System.out.println("Data not found");
		}
	}

}
