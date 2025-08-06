package com.jackson.springboot_hibernate.sample;

import com.jackson.springboot_hibernate.sample.dao.UserDao;
import com.jackson.springboot_hibernate.sample.model.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();

		// Create
		UserEntity user1 = new UserEntity("Jack", "jack@example.com");
		userDao.save(user1);


//
//		// Read
//		UserEntity fetched = userDao.get(user1.getId());
//		System.out.println("Fetched: " + fetched);
//
//		// Update
//		fetched.setEmail("jackson@newmail.com");
//		userDao.update(fetched);
//		System.out.println("Updated: " + userDao.get(fetched.getId()));
//
//		// List
//		List<UserEntity> users = userDao.getAll();
//		System.out.println("All users:");
//		users.forEach(System.out::println);
//
//		// Delete
//		userDao.delete(fetched.getId());
//		System.out.println("After delete: " + userDao.getAll());
	}
}
