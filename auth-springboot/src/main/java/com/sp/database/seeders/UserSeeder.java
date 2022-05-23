package com.sp.database.seeders;

import com.sp.model.Auth;
import com.sp.repository.AuthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class UserSeeder implements CommandLineRunner {

	@Autowired
	AuthRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		loadUserData();
	}

	private void loadUserData() {
		if (userRepository.count() == 0) {
			Auth u1 = new Auth("test@test.com", "test");
			Auth u2 = new Auth("test2@test.com", "test");
			userRepository.save(u1);
			userRepository.save(u2);
		}
	}
}
