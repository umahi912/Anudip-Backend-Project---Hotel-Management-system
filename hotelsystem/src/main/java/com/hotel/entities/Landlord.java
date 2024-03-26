package com.hotel.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Landlord {
	@Override
	public String toString() {
		return "Landlord [landlord_id=" + landlord_id + ", name=" + name + ", Address=" + Address + ", status=" + status
				+ ", hotels=" + hotels + ", admin=" + admin + "]";
	}

	public Landlord() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int landlord_id;
	private String name;
	private String Address;
	private String status;
     
	@OneToMany(mappedBy = "landLord")
	private List<Hotel> hotels;
	
	@ManyToOne
	@JoinColumn
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return landlord_id;
	}

	public void setId(int id) {
		this.landlord_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public static Landlord getLandlordLoginEmailidANDLoginPassword(String loginEmailid, String loginPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}

