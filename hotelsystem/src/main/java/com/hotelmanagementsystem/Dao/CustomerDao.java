package com.hotelmanagementsystem.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hotel.entities.Customer;

public interface CustomerDao {
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mahi");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	
	void insert(Customer customer);
	Customer getCustomerByEmailAndPassword(String email, String password);
}
