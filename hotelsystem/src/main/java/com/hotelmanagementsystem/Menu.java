package com.hotelmanagementsystem;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import com.hotelmanagementsystem.Dao.CustomerDao;
import com.hotelmanagementsystem.Dao.AdminDao;
import com.hotelmanagementsystem.Dao.RoomDao;
import com.hotelmanagementsystem.Dao.roomdaoimpl;
import com.hotelmanagementsystem.Dao.HotelDao;
import com.hotel.entities.Hotel;
import com.hotelmanagementsystem.Dao.hoteldaoimpl;
import com.hotelmanagementsystem.Dao.admindaoimpl;
import com.hotelmanagementsystem.Dao.customerdaoimpl;
import com.hotel.entities.Room;
import com.hotel.entities.Admin;
import com.hotel.entities.Customer;

public class Menu {
	private static final String loggedInAdmin = null;
	//static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	//static Session session = factory.openSession();
	static Scanner scanner = new Scanner(System.in);
	private static Session session;
		Menu(Session session )
		{
			this.session=session;
		}
	 public static void registerCustomerAccount() {
		// TODO Auto-generated method stub
		System.out.println("***Create New Customer Account***");
		System.out.println("*********");
		
		System.out.println("Customer Details");
		
		System.out.println("Enter Customer Name");
		String customer_name=scanner.nextLine();
	
		System.out.println("Enter Customer Phonenumber");
		String customer_phone_number=scanner.nextLine();
		
		System.out.println("Enter Customer aadhaar_number");
		String customer_aadhaar_number = scanner.nextLine();
		
		System.out.println("Enter Customer Emailid");
		String customer_emailid=scanner.nextLine();
		
		System.out.println("Enter Customer Password");
		String customer_password=scanner.nextLine();
		
		Customer newCustomer = Customer.addcustomer(customer_name, customer_phone_number, customer_aadhaar_number,customer_emailid,customer_password);
		//customerDAO.addcustomer(newCustomer);

		if (newCustomer == null) {
			System.out.println("Customer account created successfully!");
		} else {
			System.out.println("Customer account creation failed. Please try again.");
		}
	
	}
	public static void registerAdminAccount() {
		// TODO Auto-generated method stub
		System.out.println("***Create New Admin Account***");
		System.out.println("*********");
		
		System.out.println("*****Admin Details************");
		
		System.out.println("Enter Admin id");
		int admin_id=scanner.nextInt();
	
		System.out.println("Enter Admin Name");
		String admin_name=scanner.nextLine();
		
		
		System.out.println("Enter Admin Emailid");
		String email_id=scanner.nextLine();
		
		System.out.println("Enter password");
		String password=scanner.nextLine();
		
		AdminDao newAdmin = Admin.addadmin(admin_id,admin_name, email_id,password);
		//customerDAO.addcustomer(newCustomer);

		if (newAdmin == null) {
			System.out.println("Admin account is successfully created!");
		} else {
			System.out.println("Admin account creation failed. Please try again.");
		}
	}

	

	public static void Adminlogin() {
		// TODO Auto-generated method stub
		System.out.println("**************  LOGIN ************");
		   System.out.println("Enter Your Emailid:");
		   String LoginEmailid=scanner.nextLine();
		   System.out.println("Enter Your password:");
		   String LoginPassword=scanner.nextLine();

		    // Attempt to log in as a customer
		    Customer loggedInAdmin = Customer.getCustomerLoginEmailidANDLoginPassword(LoginEmailid,LoginPassword);

		    if (loggedInAdmin == null) {
		        
		        System.out.println("Admin login successful!");
		        adminMenu(loggedInAdmin);
		         
		    } else {
		            System.out.println("Login failed. Invalid Email and Admin_id.");
		        }
		    }
		
	
	public static void Customerlogin() {
		// TODO Auto-generated method stub
		System.out.println("**************  LOGIN ************");
		   System.out.println("Enter Your Emailid:");
		   String LoginEmailid=scanner.nextLine();
		   System.out.println("Enter Your Password:");
		   String LoginPassword=scanner.nextLine();

		    // Attempt to log in as a customer
		    Customer loggedInCustomer = Customer.getCustomerLoginEmailidANDLoginPassword(LoginEmailid,LoginPassword);

		    if (loggedInCustomer == null) {
		        
		        System.out.println("Customer login successful!");
		        customerMenu(loggedInCustomer);
		         
		    } else {
		            System.out.println("Login failed. Invalid Email and Password.");
		        }
		    }
	
	
	private static void adminMenu(Customer loggedInAdmin) {
		    Scanner scanner = new Scanner(System.in);
		    int choice;
		    do {
		        System.out.println("Admin Menu");
		        System.out.println("1. Add Rooms");
		        System.out.println("2. View All Rooms");
		        System.out.println("3. Update Rooms");
		        System.out.println("4. Delete Room");
		        System.out.println("5. Back to Main Menu");
		        System.out.print("Enter your choice: ");
		        choice = scanner.nextInt();
		        switch (choice) {
		            case 1:
		                addRoomByHotel(scanner);
		                break;
		            case 2:
		                viewAllRooms(session);
		                break;
		            case 3:
		                updateRoom(scanner);
		                break;
		            case 4:
		                deleteRoom(scanner);
		                break;
		            default:
		                System.out.println("Invalid choice. Please enter a valid option.");
		        }
		    } while (true);
		}

		
	private static void addRoomByHotel(Scanner scanner2) {
		Hotel hotel = new Hotel();
		hotel.setHotel_id(3);

		int room_id=9;
		Hotel hotelService = new Hotel();
		hotelService.addRoomsByHotelId(room_id, hotel);
	}
		
	

	private static void deleteRoom(Scanner scanner2) {
			int room_id=1;
			
			roomdaoimpl room= new roomdaoimpl();
			room.deleteById(room_id);
		}

	

	private static void updateRoom(Scanner scanner2) {
		Room room= new Room();
		room.setRoom_id(1);
		room.setRoom_price(5000.00);
		
		roomdaoimpl roomService= new roomdaoimpl();
		roomService.update(room);
	}

	private static void viewAllRooms(Session session2) {
		
		System.out.println("1.Display Empty rooms");
		System.out.println("2.Add customer to a room");
		System.out.println("3.Back To customer Menu");
		System.out.println("4.Exit");
		
	}

	
	@SuppressWarnings("unused")
	private static void customerMenu(Customer loggedInCustomer) {
	        int choice;
	        do {
	            System.out.println();
	            System.out.println("==================[ Welcome to Customer MENU ]======================");
	            System.out.println();
	            System.out.println("1) View Hotels  \n2)View rooms by price \n3.View Booking Details \n4)Log Out");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {
	                case 1:
	                    // Implement viewhotels method
	                	System.out.println("See all hotel details");
	                    System.out.println("Note: select hotel to select rooms ");
	                    ReadAllRoomsByHotelId(session);
	                    
	                    break;
	                case 2:
	                    // Implement view rooms method
	                	   System.out.println(" ===see all rooms===");
	                       System.out.println("Enter expected room price");
	                       int room_price=scanner.nextInt();
	                       if(room_price == 1000){
	                    	   System.out.println("Room is Available");
	                    	   System.out.println("Room number is 2");
	                       }else if(room_price == 2000) {
	                    	   System.out.println("Room is Available");
	                    	   System.out.println("Room number is 4");
	                       }else if(room_price == 3000) {
	                    	   System.out.println("Room is Available");
	                    	   System.out.println("Room number is 3");
	                       }else {
	                    	   System.out.println("Rooms are Unavailable");
	                       }
	                    break;
	                case 3:
	                		System.out.print("Enter your Room Id: ");
	                        int room_id = scanner.nextInt();
	                	
	                        Room room = RoomDao.getRoom();
	                   
				
	                 //   System.out.println("Total room rent: Rs" + room_price+" you have to pay ");
	                    System.out.println("Thank you.Thank you for booking.its nice to stay in our hotel");
	                    break;
	                    
	                case 4:
	                    
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }

	        } while (choice != 4);
	    }

	/*private static void ReadAllHotel(Session session2) {
		
		Hotel hotelService = new Hotel();
		List<Hotel> hotels = hotelService.readAllHotel();

		for (Hotel hotel : hotels) {
			System.out.println(hotel.getHotel_id());
			System.out.println(hotel.getHotel_name());
			System.out.println("Location = "+hotel.getHotel_location());
			System.out.println("Number of Room = " + hotel.getNum_of_rooms());
			System.out.println("Hotel rating = " + hotel.getRating());
			System.out.println();
		}
	}*/
	public static void ReadAllRoomsByHotelId(Session session2) {
		
		int hotel_id = 1;

		Hotel hotelService = new Hotel();
		List<Room> rooms = hotelService.readAllRoomsByHotelId(hotel_id);

		for (Room room : rooms) {
			System.out.println(room.getRoom_id());
			System.out.println(room.getRoom_price());
			System.out.println(room.getRoom_status());
			System.out.println("hotel id is " + room.getHotel().getHotel_id());
			System.out.println();
		}
	}

		
	}
	
	
	




