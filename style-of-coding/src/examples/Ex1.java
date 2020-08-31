package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//imperative style ( what/intention & how/implementation mixed together )

public class Ex1 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // 10 million

		// Even
		List<Integer> evens = new ArrayList<Integer>();

		Iterator<Integer> iterator = numbers.iterator();
		while (iterator.hasNext()) {
			Integer number = iterator.next();
			if (number % 2 == 0)
				evens.add(number);
		}

		System.out.println(evens);

		// Odd
		List<Integer> odds = new ArrayList<Integer>();

		iterator = numbers.iterator();
		while (iterator.hasNext()) {
			Integer number = iterator.next();
			if (number % 2 != 0)
				odds.add(number);
		}

		System.out.println(odds);

	}

}
