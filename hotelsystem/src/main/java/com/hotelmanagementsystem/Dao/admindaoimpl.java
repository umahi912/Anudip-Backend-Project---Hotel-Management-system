package com.hotelmanagementsystem.Dao;
	import java.util.List;

	import org.hibernate.Session;
	import org.hibernate.Transaction;
	import org.hibernate.query.Query;

	import com.hotel.entities.Admin;

	public class admindaoimpl implements AdminDao {
	    private Session session;

	    public admindaoimpl(Session session) {
	        this.session = session;
	    }

	    @Override
	    public void insert(Admin admin) {
	        Transaction tx = null;
	        try {
	            tx = session.beginTransaction();
	            session.save(admin);
	            tx.commit();
	            System.out.println("Record inserted into admin table: " + admin);
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Admin getAdminByEmailAndPassword(String email, String password) {
	        try {
	            Query<Admin> query = session.createQuery("FROM Admin WHERE email = :email AND password = :password", Admin.class);
	            query.setParameter("email", email);
	            query.setParameter("password", password);
	            return query.uniqueResult();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public void update(int adminid, String adminname, String email) {
	        Transaction tx = null;
	        try {
	            Admin admin = session.find(Admin.class, adminid);
	            if (admin == null) {
	                System.out.print("Record not found");
	            } else {
	                admin.setAdminName(adminname);
	                admin.setEmail(email);
	                tx = session.beginTransaction();
	                session.merge(admin);
	                tx.commit();
	                System.out.println(admin);
	                System.out.println("Record updated into admin table");
	            }
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void delete(int adminid) {
	        Transaction tx = null;
	        try {
	            Admin admin = session.find(Admin.class, adminid);
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

	    @Override
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

	    @Override
	    public void search(int adminid) {
	        try {
	            Admin admin = session.find(Admin.class, adminid);
	            if (admin == null) {
	                System.out.print("Record not found");
	            } else {
	                System.out.println(admin);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

		public Admin findByUsername(String username) {
			// TODO Auto-generated method stub
			return null;
		}
	}


