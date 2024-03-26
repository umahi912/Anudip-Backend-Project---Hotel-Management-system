package com.hotelmanagementsystem.Dao;

import java.util.Scanner;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;

import com.hotel.entities.Admin;
import com.hotel.entities.Hotel;
import com.hotel.entities.Room;

public class roomdaoimpl {
	private static final Object roomid = null;
	private static final String room_id = null;
	private static final int hotel_id = 0;
	private static final String room_status = null;
	Scanner sc=new Scanner(System.in);
	private SharedSessionContract session;
	private Object room_price;
	/*public void deleteById(int room_id) {
		
		 int roomid=sc.nextInt();
		 System.out.println("Delete the room as you mentioned.");
	}*/
	public void deleteById (int room_id){
        Transaction tx = null;
        try {
            Room room = new Room();
            if (room == null) {
                System.out.print("Record not found");
            } else {
                tx = session.beginTransaction();
                ((EntityManager) session).remove(room);
                tx.commit();
                System.out.println(room);
                System.out.println("Record deleted from admin table");
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
	public void update(Room room) {
		// TODO Auto-generated method stub
		
	        Transaction tx = null;
	        try {
	        	Hotel hotel = ((EntityManager) session).find(Hotel.class, room_id);
	            if (hotel == null) {
	                System.out.print("Record not found");
	            } else {
	                hotel.setRoom_id(room_id);
	                hotel.setRoom_price(room_price);
	                hotel.setRoom_status(room_status);
	                tx = session.beginTransaction();
	                ((EntityManager) session).merge(hotel);
	                tx.commit();
	                System.out.println(hotel);
	                System.out.println("Record updated into hotel table");
	            }
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	}


