package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.configuration.DBconfig;
import com.niit.dao.Userdao;
import com.niit.model.User;

@ComponentScan("com.niit")
public class Usertest {

static Userdao  userdao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBconfig.class);
		context.scan("com.niit");
		context.refresh();

		userdao=(Userdao)context.getBean("userdao");
	}
	
	@Test
	public void addUserTest()
	{
		User user=new User();
		//user.setUser_id(1);
		user.setFirstName("sathish");
		user.setLastName("kumar");
		user.setContact("9581420111");
		user.setEmail("sathish@gmail.com");
		user.setPassword("123");
		user.setRole("Admin");
		assertTrue("Problem in Inserting user", userdao.saveOrUpdate(user));	}

		
	}

