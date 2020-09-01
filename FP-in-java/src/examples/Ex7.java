package examples;

import java.util.function.Predicate;

public class Ex7 {

	public static void main(String[] args) {

		Predicate<String> isEmpty = s -> s.isEmpty();
		Predicate<String> isNotEmpty = isEmpty.negate();
		

	}

}
