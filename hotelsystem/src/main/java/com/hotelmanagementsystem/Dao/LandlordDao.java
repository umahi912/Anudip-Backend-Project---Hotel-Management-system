package com.hotelmanagementsystem.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hotel.entities.Landlord;

public abstract class LandlordDao{
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mahi");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	abstract void create(Landlord landlord);
	abstract void update(Landlord landlord);
	abstract void delete(int id);
	public abstract List<Landlord> readAllLandlord();
}