package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@CrossOrigin(origins = {"*"})
@RestController
public class NumberController {
	
	@Autowired
	private NumberService numberService;

	@GetMapping(value = "/api/random/numbers",produces = {"text/event-stream"})
	public Flux<Integer> getRandomNumbers() {
		return numberService.getRandomNumbers();
		
	}
	
}
