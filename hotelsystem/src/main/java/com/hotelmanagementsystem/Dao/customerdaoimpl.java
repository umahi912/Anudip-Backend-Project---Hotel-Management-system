package com.hotelmanagementsystem.Dao;


import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hotel.entities.Customer;

public class customerdaoimpl  implements CustomerDao{
	private Session session;
	public void Customerdaoimpl(Session session)
	{
		this.session=session;
	}

		public void insert(Customer customer) {
			try {
				Transaction tx = session.beginTransaction();
				session.save(customer);
				tx.commit();

				//System.out.println(customer);
				System.out.println("Record inserted into customer table");		
			  } catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public Customer getCustomerByEmailAndPassword(String email, String password) {
			  try {
		            String hql = "FROM customer WHERE customer_email = :email AND customer_password = :password"; 
		            TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		            query.setParameter("email", email);
		            query.setParameter("password", password);
		            return query.getSingleResult();
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        }
		}
			}

		

		
		


