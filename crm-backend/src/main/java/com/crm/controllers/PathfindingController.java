package com.crm.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crm.models.Greeting;

import org.springframework.http.ResponseEntity;

@RestController
public class PathfindingController {
	private static List <Greeting> greetings = new ArrayList<Greeting>();
	int i = 0;

//	@GetMapping("/greeting")
//	public Greeting greeting(@RequestParam(required = false, defaultValue= "World") String name) {
//		System.out.println("=======get-greeting=======");
//		return new Greeting(1, "HelloWorld");
//	}
	@CrossOrigin()
	@GetMapping("/greeting")
	public List<Greeting> returnGreetings() {
		System.out.println("=======get-greetings=======");
		return greetings;
	}
	@CrossOrigin()
	@PostMapping("/message")
	public ResponseEntity<Greeting> greeting(@RequestBody Greeting greet) {
		System.out.println("=======post-greeting=======");
		greet.setId(++i);
		greetings.add(greet);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(greet.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
}
