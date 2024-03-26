package com.hotelmanagementsystem.Dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hotel.entities.Admin;

public interface AdminDao {
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mahi");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	
    void insert(Admin admin); 
    Admin getAdminByEmailAndPassword(String email, String password);
    void update(int adminid,String adminname,String email);
    void delete(int adminid);
    List<Admin> select();
	void search(int adminid);
}
