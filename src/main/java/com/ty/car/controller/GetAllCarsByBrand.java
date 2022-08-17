package com.ty.car.controller;

import java.util.List;

import com.ty.car.dao.CarDao;
import com.ty.car.dto.Car;

public class GetAllCarsByBrand {
	public static void main(String[] args) {

		CarDao carDao = new CarDao();
		List<Car> cars = carDao.getAllCarsByBrand("audi");
		if (cars != null) {
			for (Car car : cars) {
				System.out.println("Id is " + car.getId());
				System.out.println("Name is " + car.getName());
				System.out.println("Brand is " + car.getBrand());
				System.out.println("Cost is " + car.getCost());
				System.out.println("-------------------------------------");
			}
		} else {
			System.out.println("No cars Found");
		}
	}

}
