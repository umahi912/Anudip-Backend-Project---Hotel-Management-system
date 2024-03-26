package com.hotelmanagementsystem;

import java.util.Scanner;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class Main {
	 public static void main(String args[])
	{
		try {
			
		 Scanner sc=new Scanner(System.in);
		Main main=new Main();
		//Menu menu=new Menu();
		
		int choice;
		//int ch;
		do {
			System.out.println("Hello Hi");
			System.out.println("Welcome to Hotel Management System");
			System.out.println("1.Create Admin Account \n2.Create Customer Account \n3.Login Admin Account \n4.Login Customer Account \n5.Exit");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			switch(choice) {
			//int ch=sc.nextInt();
			case 1:{
                 Menu.registerAdminAccount();
                 break;
			}
			case 2:
				 Menu.registerCustomerAccount();
				break;
			case 3:
				 Menu.Adminlogin();
				break;
			case 4:
				 Menu.Customerlogin();
				break;
			default:
				System.out.println("Wrong Input!!");
		
		}
		}while(true);
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            }
	}
}
