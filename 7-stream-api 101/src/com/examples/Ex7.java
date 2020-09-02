package com.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex7 {

	public static void main(String[] args) {

		List<String> titles = Arrays.asList("Modern", "Java", "In", "Action");
		Stream<String> stream = titles.stream();

		stream.forEach(System.out::println);
//		stream.forEach(System.out::println); // Exception
	}

}
