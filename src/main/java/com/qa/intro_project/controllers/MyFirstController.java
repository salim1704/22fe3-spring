package com.qa.intro_project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @RestController signifies that this is a Spring Bean, specifically a controller for handling requests
// - the @Controller annotation is used instead when we want to return HTML using views (MVC)
@RestController
// @RequestMapping sets the path that this controller will handle
// - for example, this controller handles any request sent to http://localhost:8080/myroute
@RequestMapping(path = "/myroute")
public class MyFirstController {

	// @GetMapping signifies that this method will handle GET requests to the specified path
	// - http://localhost:8080/myroute
	// - @GetMapping is a specialisation of @RequestMapping
	// The following @RequestMapping is equivalent to @GetMapping
//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String myFirstRoute() {
		return "Hello from my Spring Web App";
	}
	
	// We can also define routes with customised paths
	@GetMapping(path = "/second") // localhost:8080/myroute/second
	public String mySecondRoute() {
		return "Hello from my other route";
	}
	
}
