package examples;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterface_Ex {

	public static void main(String[] args) {

		// ----------------------------------------------------
		Consumer<String> consumer = s -> {
			System.out.println(s);
		};
		// consumer.accept("Hello");
		// ----------------------------------------------------
		Supplier<String> supplier = () -> {
			return "Hello";
		};
		String message = supplier.get();
		// ----------------------------------------------------
		Function<String, String> function = s -> {
			return s.toUpperCase();
		};
		String newMessage = function.apply("hello");
		// System.out.println(newMessage);
		// ----------------------------------------------------
		Predicate<String> predicate = s -> s.isEmpty();
		boolean b = predicate.test("hello");
		// ----------------------------------------------------

		BiConsumer<String, String> biConsumer = (s1, s2) -> {
			System.out.println(s1 + " " + s2);
		};
		// biConsumer.accept("helllo", "capgemeni");

		// ----------------------------------------------------
		BiFunction<Integer, Integer, Integer> biFunction = (n1, n2) -> {
			return n1 + n2;
		};
		int result = biFunction.apply(12, 13);
		// ----------------------------------------------------
		BiPredicate<Integer, Integer> biPredicate = (n1, n2) -> n1 > n2;
		// ----------------------------------------------------

		UnaryOperator<String> unaryOperator = s -> s.toUpperCase();

		// ----------------------------------------------------

		BinaryOperator<Integer> binaryOperator = (n1, n2) -> n1 + n2;
		int x = 12;
		int y = 13;
		int z = binaryOperator.apply(x, y);
		// ----------------------------------------------------

		IntBinaryOperator intBinaryOperator = (n1, n2) -> n1 + n2;
		z = intBinaryOperator.applyAsInt(x, y);

		// ----------------------------------------------------

	}

}
