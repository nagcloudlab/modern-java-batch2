package examples;

import java.util.stream.IntStream;

// Numeric streams

public class Ex2 {
	
	public static void main(String[] args) {
		
		IntStream.range(1, 10)
		.forEach(System.out::println);;
		
	}

}
