package com.examples;

import java.util.List;
import java.util.OptionalInt;

public class Ex {

	public static void main(String[] args) {

		List<Integer> list = List.of(1,2,3,4,5);

		OptionalInt optionalInt = 
				                 list
				                 .stream()
				                 .mapToInt(n -> n)
				                 .max();
		
//		if(optionalInt.isPresent()) {
//			System.out.println(optionalInt.getAsInt());
//		}else {
//			System.out.println("list is empty");
//		}

		
//		int max=optionalInt.orElse(0);
//		System.out.println(max);
		
//		
//		int max=optionalInt.orElseThrow(()->new IllegalStateException());
//		System.out.println(max);
		
		
		
		
	}

}
