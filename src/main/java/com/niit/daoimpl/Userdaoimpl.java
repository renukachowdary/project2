package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.Userdao;
import com.niit.model.User;

@Repository("userdao")
public class Userdaoimpl implements Userdao{

	Logger Logger=LoggerFactory.getLogger(Userdaoimpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public Userdaoimpl(SessionFactory sessionFactory) {
	
		this.sessionFactory=sessionFactory;
	}

	public boolean saveOrUpdate(User user) {
		Logger.info("save Operation started", user.getUser_id());
		Session session=sessionFactory.openSession();

		Transaction tx=session.beginTransaction();
		user.setEnable(true);
		user.setIsonline(false);
		session.saveOrUpdate(user);
		tx.commit();
		Logger.info("User object has been saved successfually", user.getUser_id());
	
		return true;			
	
	}

	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(User user) {

		// TODO Auto-generated method stub
		
	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public User viewUser(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> UserList() {
		// TODO Auto-generated method stub
		return null;
	}

	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUsernameValid(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmailValid(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}