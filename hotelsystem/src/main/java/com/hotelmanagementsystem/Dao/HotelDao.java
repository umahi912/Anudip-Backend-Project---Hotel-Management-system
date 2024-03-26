package com.hotelmanagementsystem.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hotel.entities.Hotel;

public interface HotelDao{
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mahi");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	 
	abstract void create(Hotel hotelid);
	 abstract void update(Hotel hotelid);
	 abstract void delete(int id);
	 abstract List<Hotel> readAllHotel();
}