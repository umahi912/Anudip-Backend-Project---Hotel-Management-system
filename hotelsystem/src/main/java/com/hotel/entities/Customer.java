package com.hotel.entities;

	import java.io.Serializable;
	import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;

	@Entity
	public class Customer {
		public static final String getCustomer_phone_num = null;




		//public static final String getCustomer_phone_num = null;

			@Override
		public String toString() {
			return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_phone_num="
					+ customer_phone_num + ", customer_aadhaar_num=" + customer_aadhaar_num + ", customer_emailid="
					+ customer_emailid + ", customer_password=" + customer_password + ", rooms=" + rooms + "]";
		}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int customer_id;
		private String customer_name;
		private String customer_phone_num;
		private int customer_aadhaar_num;
		private String customer_emailid;
		private String customer_password;

		@OneToMany(mappedBy = "customer")
		private List<Room> rooms;
		

		

		public int getCustomer_id() {
			return customer_id;
		}
		public void setCustomer_id(int customer_id) {
			this.customer_id = customer_id;
		}
		public String getCustomer_name() {
			return customer_name;
		}
		public void setCustomer_name(String customer_name) {
			this.customer_name = customer_name;
		}

		public String getCustomer_phone_num() {
			return customer_phone_num;
		}
		public void setCustomer_phone_num() {
			this.customer_phone_num=customer_phone_num;
		}
		public void setCustomer_emailid(String customer_emailid) {
			this.customer_emailid = customer_emailid;
		}
		public void setCustomer_password(String customer_password) {
			this.customer_password = customer_password;
		}
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		public List<Room> getRooms() {
			return rooms;
		}

		public void setRooms(List<Room> rooms) {
			this.rooms = rooms;
		}

		
		public void setCustomer_aadhaar_num(Object object) {
			// TODO Auto-generated method stub
			
		}

		public Object getCustomer_aadhaar_num() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setCustomer_aadhar_num(String string) {
			// TODO Auto-generated method stub
			
		}

		public void setCustomer_phone_num(String string) {
			// TODO Auto-generated method stub
			
		}

		public Object getCustomer_emailid() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setCustomer_emailid(Object customer_emailid2) {
			// TODO Auto-generated method stub
			
		}

		public Object getCustomer_password() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setCustomer_password(Object customer_password2) {
			// TODO Auto-generated method stub
			
		}
		public void setCustName(String next) {
			// TODO Auto-generated method stub
			
		}
		public void setCustPhoneNumber(String next) {
			// TODO Auto-generated method stub
			
		}
		public void setAadhaarNumber(String next) {
			// TODO Auto-generated method stub
			
		}
		public void setCustEmail(String next) {
			// TODO Auto-generated method stub
			
		}
		public void setPassword(String next) {
			// TODO Auto-generated method stub
			
		}
			public static Customer addcustomer(String customer_name, String customer_phone_number,
			String customer_aadhaar_number, String customer_emailid, String customer_password) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Customer getCustomerLoginEmailidANDLoginPassword(String loginEmailid, String loginPassword) {
		// TODO Auto-generated method stub
		return null;
	}


	
}