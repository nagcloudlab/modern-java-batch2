package com.example.demo;

import java.time.Duration;
import java.util.Random;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class NumberService {

	public Flux<Integer> getRandomNumbers() {
		
		Random random=new Random();
		
		return Flux
		.interval(Duration.ofSeconds(1))
		.map(tick->random.nextInt(1000))
		.map(n->n*n)
		.filter(n->n>0);
		
	}
	
}
