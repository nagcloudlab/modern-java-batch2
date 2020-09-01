package examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//declarative style ( what/intention & how/implementation loosely coupled ) 

public class Ex4 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		
		// Even
		List<Integer> evens = numbers
				              .stream()
				              .filter(t->t%2==0)
				              .collect(Collectors.toList());

		System.out.println(evens);

		// Odd
		List<Integer> odds = numbers
				              .stream()
				              .filter(t->t%2!=0)
				              .collect(Collectors.toList());
		System.out.println(odds);

	}

	

}
