package examples;

import java.util.function.Predicate;

/*
 * 
 *  why we need lambda expression?
 *  
 *  reason-2 : to enable higher-order-programming
 * 
 */

public class Ex2 {

	// HOF
	public static Predicate<Integer> makeAndFunction(Predicate<Integer> p1, Predicate<Integer> p2) {
		Predicate<Integer> predicate = n -> {
			return p1.test(n) && p2.test(n);
		};
		return predicate;
	}

	public static void main(String[] args) {

		Predicate<Integer> isMin = n -> n < 1000;
		Predicate<Integer> isMax = n -> n > 100;

		int n = 500;

		Predicate<Integer> and = makeAndFunction(isMin, isMax);

//		boolean b = isMin.test(n) && isMax.test(n);
		boolean b = and.test(n);
		System.out.println(b);

		n = 1100;

//		b= isMin.test(n) && isMax.test(n);
		b = and.test(n);
		System.out.println(b);

	}

}
