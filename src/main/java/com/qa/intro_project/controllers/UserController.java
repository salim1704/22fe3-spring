package com.qa.intro_project.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.intro_project.data.entity.User;

@RestController
@RequestMapping(path = "/user") // accepts requests at localhost:8080/user
public class UserController {

	// the list of users is just pretending to be a database for now
	private static int COUNTER = 1;
	private List<User> users = new ArrayList<>(List.of(new User(COUNTER++, "Fred"), new User(COUNTER++, "Sarah")));
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok(users);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> getUser(@PathVariable(name = "id") int id) {
		for (int i = 0; i < users.size(); i++) {
			User current = this.users.get(i);
			if (current.getId() == id) {
				return new ResponseEntity<User>(current, HttpStatus.OK);
			}
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		int id = COUNTER++;
		user.setId(id);
		users.add(user);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "http://localhost:8080/user/" + id);

		return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public User updateUser(@RequestBody User user, @PathVariable(name = "id") int id) {
		return null;
	}
	
	@DeleteMapping(path = "/{id}")
	public User deleteUser(@PathVariable(name = "id") int id) {
		return null;
	}
}
