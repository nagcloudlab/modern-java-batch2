package com;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class User {
	private String username;
	private String password;
	private String name;

	public User(String username, String password, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + "]";
	}

}

//-------------------------------------------------------
// Module -1 : repository
//-------------------------------------------------------

interface UserRepository {
//	User findUser(String username) throws Exception;
//	Future<User> findUser(String username);
	CompletableFuture<User> findUser(String username);
}

class JpaUserRepository implements UserRepository {

//	@Override
//	public User findUser(String username) throws Exception {
//		TimeUnit.SECONDS.sleep(5);
//		return new User(username, "shhhh", "USER ONE");
//	}

//	@Override
//	public Future<User> findUser(String username) {
//		Callable<User> callable = () -> {
//			TimeUnit.SECONDS.sleep(5);
//			return new User(username, "shhhh", "USER ONE");
//		};
//		ExecutorService executorService = Executors.newFixedThreadPool(8);
//		Future<User> future = executorService.submit(callable);
//		return future;
//	}

	@Override
	public CompletableFuture<User> findUser(String username) {
		
		ExecutorService tPool1=Executors.newFixedThreadPool(3);

		return CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("UserRepository : pushing/propagating user data "+Thread.currentThread().getName());
			return new User(username, "shhhh", "USER ONE");
		},tPool1);

	}

}

//-------------------------------------------------------

//-------------------------------------------------------
// Module -2 : service
//-------------------------------------------------------

class AuthService {

	private UserRepository userRepository;

	public AuthService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public void authenticate(String username, String passpaword) {
		// ..
		try {

			System.out.println("AuthService : invoking findUser()");

//			User user = userRepository.findUser(username); // pull / block-call / sync-api
//			System.out.println(user);

//			Future<User> future = userRepository.findUser(username);
//			// ...
//			User user = future.get(); // block
//			System.out.println(user);
			
			ExecutorService tPool2=Executors.newCachedThreadPool();

			CompletableFuture<User> completableFuture = userRepository.findUser(username);
			completableFuture.thenAcceptAsync(user -> {
				System.out.println("AuthService : reacting to user data "+Thread.currentThread().getName());
				System.out.println(user);
			},tPool2);

			System.out.println("AuthService ....");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

//-------------------------------------------------------

public class Ex1 {

	public static void main(String[] args) throws InterruptedException {

		AuthService authService = new AuthService(new JpaUserRepository());
		authService.authenticate("user1", "shhh");
		
		
		TimeUnit.SECONDS.sleep(10);

	}

}
