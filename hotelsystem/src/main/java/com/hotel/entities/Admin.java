package com.hotel.entities;

import com.hotelmanagementsystem.Dao.AdminDao;
	import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;

	@Entity
	public class Admin {
		public Admin() {
			super();
				// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", email_id=" + email_id + ", landLords="
					+ landLords + "]";
		}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int admin_id;
		private String admin_name;
		private String email_id;
		private String password;

		@OneToMany(mappedBy = "admin")
		private List<Landlord> landLords;

		public int getAdmin_id() {
			return admin_id;
		}

		public void setAdmin_id(int admin_id) {
			this.admin_id = admin_id;
		}

		public String getAdmin_name() {
			return admin_name;
		}

		public void setAdmin_name(String admin_name) {
			this.admin_name = admin_name;
		}

		public String getEmail_id() {
			return email_id;
		}

		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

		public List<Landlord> getLandLords() {
			return landLords;
		}

		public void setLandLords(List<Landlord> landLords) {
			this.landLords = landLords;
		}

		public void setAdminName(String next) {
			// TODO Auto-generated method stub
			
		}

		public void setEmail(String next) {
			// TODO Auto-generated method stub
			
		}

		
		public static AdminDao addadmin(int admin_id, String admin_name, String email_id, String password) {
			// TODO Auto-generated method stub
			return null;
			

		}




}
