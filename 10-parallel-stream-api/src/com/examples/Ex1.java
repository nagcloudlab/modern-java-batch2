package com.examples;

import java.util.stream.Stream;

public class Ex1 {
	
	public static long iterativeSum(long n) {
		long result=0L;
		for (long i = 1L; i <= n; i++) {
			result+=i;
		}
		return result;
	}
	
	public static long sequatialSum(long n) {
		return Stream.iterate(1L, i->i+1)
				      .limit(n)
				      .reduce(0L, Long::sum);
	}


	public static long parallelSum(long n) {
		return Stream.iterate(1L, i->i+1)
				      .limit(n)
				      .parallel()
				      .reduce(0L, Long::sum);
	}


	public static void main(String[] args) {

		System.out.println(
				
				//iterativeSum(10)
				parallelSum(100000000L)
				
		);
		
	}

}
