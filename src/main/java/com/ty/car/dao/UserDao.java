package com.ty.car.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.car.dto.User;
import com.ty.car.helper.AES;

public class UserDao {
	static EntityManagerFactory managerFactory;
	static EntityManager entityManager;
	static {
		managerFactory = Persistence.createEntityManagerFactory("vikas");
		entityManager = managerFactory.createEntityManager();
	}

	public void saveUser(User user) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query = entityManager.createNativeQuery("INSERT INTO user (id,name,email,password) VALUES(?,?,?,?)");
		query.setParameter(1, user.getId());
		query.setParameter(2, user.getName());
		query.setParameter(3, user.getEmail());
		query.setParameter(4, AES.encrypt(user.getPassword()));

		entityTransaction.begin();

		query.executeUpdate();

		entityTransaction.commit();
	}

	public User validateUser(String email, String password) {
		List<User> users = new ArrayList<>();

		String jpql = "SELECT u FROM User u WHERE EMAIL=?1 AND PASSWORD=?2";

		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, AES.encrypt(password));

		//User user = (User) query.getSingleResult();---->NoResultException and NonUniqueResultException
		users = query.getResultList();

		User user = null;
		if (!users.isEmpty()) {
			user = users.get(0);
		}
		return user;
	}

	public User getUserByEmail(String email) {
		List<User> users = new ArrayList<>();

		String jpql = "SELECT u FROM User u WHERE EMAIL=:myEmail";

		Query query = entityManager.createQuery(jpql);
		query.setParameter("myEmail", email);

		users = query.getResultList();

		return users.isEmpty() ? null : users.get(0);
	}

	public boolean deleteUser(int id) {
		boolean result = false;

		EntityTransaction entityTransaction = entityManager.getTransaction();

		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			result = true;
		}
		return result;
	}
}
