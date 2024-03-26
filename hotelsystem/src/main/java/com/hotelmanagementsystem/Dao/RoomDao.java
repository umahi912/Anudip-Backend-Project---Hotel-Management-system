package com.hotelmanagementsystem.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hotel.entities.Room;


	public interface RoomDao {
		static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mahi");
		static EntityManager entityManager = entityManagerFactory.createEntityManager();
		static EntityTransaction entityTransaction = entityManager.getTransaction();
	   
		void insert(Room room); 
	    static Room getRoomById() {
			  
			return null;
		}
	    void update(int room_id,String room_price,String room_status);
	    void delete(int adminid);
	    List<Room> select();
		void search(int room_id);
		static Room getRoom() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}	
/*	void Room(){

	    addRoom = new ArrayList<Room>();                     
	    for(int i=0;i<roomID.length;i++)
	    {
	        addRoom(new Room(roomID[i]));
	    }

	}

	public void addRoom(Room addRoom){
	    addRoom.add(addRoom);
	}

	public ArrayList<Room> getRoom(){
	    return addRoom;
	}
	}*/