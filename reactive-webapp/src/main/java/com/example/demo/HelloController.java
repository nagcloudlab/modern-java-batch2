package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

	@GetMapping
	public Mono<String> hello() {
		System.out.println("new request....." + Thread.currentThread());
		return Mono.fromSupplier(() -> {
			try {
				TimeUnit.SECONDS.sleep(5); // IO , DB-call , N/W-call
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hello capgemeni";
		});
	}

}
