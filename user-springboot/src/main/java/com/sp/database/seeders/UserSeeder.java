package com.sp.database.seeders;

import com.sp.model.User;
import com.sp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class UserSeeder implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		loadUserData();
	}

	private void loadUserData() {
		if (userRepository.count() == 0) {
			User u1 = new User("test@test.com", "Test", "Test", 1000, 1);
			User u2 = new User("test2@test.com", "Test", "Test", 500,2);
			userRepository.save(u1);
			userRepository.save(u2);
		}
	}
}
