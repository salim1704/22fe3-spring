package com.qa.intro_project.configuration;

import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qa.intro_project.data.entity.User;
import com.qa.intro_project.data.repository.UserRepository;

@Profile("dev") // Only runs on the dev profile
@Configuration // Indicates this file contains bean candidates for component scanning
public class DevStartupListener implements ApplicationListener<ApplicationReadyEvent> {
	
	private UserRepository userRepository;
	
	public DevStartupListener(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Waits until the app is truly ready before saving the users
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		userRepository.saveAll(List.of(
				new User("Fred", "fred@mail.com"),
				new User("Sarah", "sarah@mail.com")
		));
	}

}
