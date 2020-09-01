package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

//declarative style ( what/intention & how/implementation loosely coupled ) 

public class Ex3 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Even
		List<Integer> evens = filter(numbers, t -> t % 2 == 0);

		System.out.println(evens);

		// Odd
		List<Integer> odds = filter(numbers, t -> t % 2 != 0);
		System.out.println(odds);

	}

	public static List<Integer> filter(List<Integer> inp, Predicate<Integer> predicate) {
		List<Integer> out = new ArrayList<Integer>();
		// ..
		Iterator<Integer> iterator = inp.iterator();
		while (iterator.hasNext()) {
			Integer number = iterator.next();
			if (predicate.test(number))
				out.add(number);
		}

		return out;
	}

}
