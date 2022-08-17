package com.ty.car.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.car.dto.Car;

public class CarDao {

	static EntityManagerFactory managerFactory;
	static EntityManager entityManager;
	static {
		managerFactory = Persistence.createEntityManagerFactory("vikas");
		entityManager = managerFactory.createEntityManager();
	}

	public void saveCar(Car car) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(car);
		entityTransaction.commit();
	}

	public Car getCarById(int id) {
		Car car = entityManager.find(Car.class, id);
		return car;
	}

	public boolean deleteCarById(int id) {
		boolean result = false;
		if (getCarById(id) != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(getCarById(id));
			entityTransaction.commit();
			result = true;
		}
		return result;
	}

	public boolean updateCarById(int id) {
		boolean result = false;
		Car car = getCarById(id);
		if (car != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			car.setCost(35000000);
			entityManager.merge(car);
			entityTransaction.commit();
			result = true;
		}
		return result;
	}

	public List<Car> getAllCars() {
		List<Car> cars = new ArrayList<>();
		String jpql = "SELECT c FROM Car c";

		Query query = entityManager.createQuery(jpql);

		cars = query.getResultList();

		return cars;
	}

	public List<Car> getAllCarsByBrand(String brand) {
		List<Car> cars = new ArrayList<>();
		String jpql = "SELECT c FROM Car c WHERE BRAND=?1";

		Query query = entityManager.createQuery(jpql);

		query.setParameter(1, brand);

		cars = query.getResultList();

		return cars;
	}

	public List<Car> getAllCarsByRange(double start, double end) {
		List<Car> cars = new ArrayList<>();
		String jpql = "SELECT c FROM Car c WHERE COST>= :start AND COST<=:end";

		Query query = entityManager.createQuery(jpql);
		query.setParameter("start", start);
		query.setParameter("end", end);

		cars = query.getResultList();

		return cars;
	}
}
