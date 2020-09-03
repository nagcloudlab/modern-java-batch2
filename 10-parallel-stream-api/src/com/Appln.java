package com;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 
 *  tasks
 *  ------
 *  
 *   -> computation
 *   -> io
 * 
 */

public class Appln {

	public static void computation() {

		String name = Thread.currentThread().getName();
		System.out.println("T-" + name + " started computation");
		while (true) {
		}
		// System.out.println("T-" + name + " finished computation");
	}

	public static void io() {
		String name = Thread.currentThread().getName();
		System.out.println("T-" + name + " started io");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name!");
		String userName = scanner.nextLine();
		System.out.println("Hello " + userName);
		System.out.println("T-" + name + " finished io");
		scanner.close();
	}

	public static void main(String[] args) {

		String name = Thread.currentThread().getName();
		System.out.println("T-" + name + " started execution");

		Runnable ioTask = () -> {
			io();
		};
		Runnable computationTask = () -> {
			computation();
		};

		// --------------------------------------------------

		// 1.0

//		Thread ioThread = new Thread(ioTask, "IO");
//		ioThread.start();
//
//		Thread compThread = new Thread(computationTask, "COMPUTATION");
//		compThread.start();

		// ..

		// --------------------------------------------------

		// --------------------------------------------------

		// 1.5 --> thread-pool f.w i.e executor service

		ExecutorService executorService = Executors.newFixedThreadPool(8);
		executorService.submit(ioTask);
		executorService.submit(computationTask);

		// --------------------------------------------------

		// --------------------------------------------------

		//1.7   --> ForkJoin F.W  , uses 'CommonThreadPool' / 'WorkStealing' pool
		
		
		
		

	}

}
