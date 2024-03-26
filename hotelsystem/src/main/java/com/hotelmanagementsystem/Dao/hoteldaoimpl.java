package com.hotelmanagementsystem.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hotel.entities.Admin;
import com.hotel.entities.Hotel;
import com.hotel.entities.Room;
import com.hotelmanagementsystem.Dao.HotelDao;

public abstract class hoteldaoimpl implements HotelDao {
    private Session session;

    public hoteldaoimpl() {
        this.session = session;
    }

    public void insert(Hotel hotel) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(hotel);
            tx.commit();
            System.out.println("Record inserted into hotel table: " + hotel);
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public Admin getHotelByRoomId(int hotel_id) {
        try {
            Query<Admin> query = session.createQuery("FROM Admin WHERE email = :email AND password = :password", Admin.class);
            query.setParameter("room_id", hotel_id);
            //query.setParameter("password", password);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(int hotel_id,String hotel_location) {
        Transaction tx = null;
        try {
        	Hotel hotel = session.find(Hotel.class, hotel_id);
            if (hotel == null) {
                System.out.print("Record not found");
            } else {
                hotel.setHotel_id(hotel_id);
                hotel.setHotel_location(hotel_location);
                tx = session.beginTransaction();
                session.merge(hotel);
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

    public void delete(int hotelid) {
        Transaction tx = null;
        try {
            Admin admin = session.find(Admin.class, hotelid);
            if (admin == null) {
                System.out.print("Record not found");
            } else {
                tx = session.beginTransaction();
                session.remove(admin);
                tx.commit();
                System.out.println(admin);
                System.out.println("Record deleted from admin table");
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Admin> select() {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Admin> qobj = session.createQuery("FROM Admin", Admin.class);
            List<Admin> list = qobj.getResultList();
            tx.commit();
            return list;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    public void search(int hotel_id) {
        try {
           Hotel hotel = session.find(Hotel.class, hotel_id);
            if (hotel == null) {
                System.out.print("Record not found");
            } else {
                System.out.println(hotel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public Admin findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addRoomsByHotelId(Object room_id, Hotel hotel) {
		// TODO Auto-generated method stub
		Room room = new Room();
		room.setRoom_id(3);

		int room_id1=4;
		Hotel hotel1=new Hotel();
		//hoteldaoimpl hotelService = new hoteldaoimpl();
		hotel1.addRoomsByHotelId(room_id1, hotel1);
	}

	public List<Hotel> readAllHotel() {
		// TODO Auto-generated method stub
		return null;
	}

	
	}
	

