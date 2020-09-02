package examples;

import java.util.Random;
import java.util.stream.Stream;

/*
 * 
 *  finite vs infinite streams
 * 
 */

public class Ex3 {

	public static void main(String[] args) {

		// ------------------------------------------------
		// finite stream
		// ------------------------------------------------

//		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
//		
//		numbers
//		.stream()
//		.map(n->n*n)
//		.forEach(System.out::println);

		// ------------------------------------------------
		// infinite stream
		// ------------------------------------------------

		// way-1 : iterate

//		Stream
//		.iterate(0, n->n+1)
//		.filter(n->n%2==0)
//		.filter(n->n>100)
//		.limit(100)
//		.forEach(System.out::println);

		// way-2 : generate

		Random random = new Random();

		Stream.generate(() -> random.nextInt()).filter(n -> n > 0).limit(10).forEach(System.out::println);

		// ------------------------------------------------

	}

}
