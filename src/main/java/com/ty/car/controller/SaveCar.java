package com.ty.car.controller;

import com.ty.car.dao.CarDao;
import com.ty.car.dto.Car;

public class SaveCar {

	public static void main(String[] args) {
		CarDao dao = new CarDao();
		Car car = new Car();
		car.setId(6);
		car.setName("audi a6");
		car.setCost(19000000);
		car.setBrand("AUDI");
		dao.saveCar(car);
	}

}
