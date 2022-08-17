package com.ty.car.controller;

import com.ty.car.dao.CarDao;
import com.ty.car.dto.Car;

public class GetCarById {
	public static void main(String[] args) {
		CarDao dao = new CarDao();
		Car car = dao.getCarById(4);
		if (car != null) {
			System.out.println("Car id - " + car.getId());
			System.out.println("Car name - " + car.getName());
			System.out.println("Car brand - " + car.getBrand());
			System.out.println("Car cost - " + car.getCost());
		} else {
			System.out.println("Data not found");
		}
	}

}
