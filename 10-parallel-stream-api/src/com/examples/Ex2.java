package com.examples;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Ex2 {

	public static int transform(int n) {
		// ..
		System.out.println("T : "+Thread.currentThread() +" => "+n);
		return n;
	}
	public static void printIt(int n) {
		System.out.println("P : "+Thread.currentThread() +" => "+n);
	}

	public static void main(String[] args) throws InterruptedException{

		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		ForkJoinPool forkJoinPool=new ForkJoinPool(100);
		forkJoinPool.submit(()->{

			numbers
			.stream()
			.parallel()
			.map(Ex2::transform)
			.forEachOrdered(Ex2::printIt);
			
		});
		
		TimeUnit.SECONDS.sleep(10);

	}

}
