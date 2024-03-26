package com.hotel.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Room {
	private static final boolean booked = false;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int room_id;
	private Double room_price;
	private String room_status;

	@ManyToOne
	@JoinColumn
	private Hotel hotel;

	@ManyToOne
	@JoinColumn
	private Customer customer;
	private String roomID;

	public int getRoom_id() {
		return room_id;
	}

	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", room_price=" + room_price + ", room_status=" + room_status + ", hotel="
				+ hotel + ", customer=" + customer + "]";
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public Double getRoom_price() {
		return room_price;
	}

	public void setRoom_price(Double room_price) {
		this.room_price = room_price;
	}

	public String getRoom_status() {
		return room_status;
	}

	public void setRoom_status(String room_status) {
		this.room_status = room_status;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	Room(String roomID)
	{
	    this.roomID = roomID;
	}

	String getRoomID()
	{
	    return roomID;
	}

	void cancel()
	{
	    boolean booked = false;
	}


	boolean isBooked()
	{
	    return booked;
	}

	public Room[] getRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	

	}




