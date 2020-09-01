package examples;

import java.util.function.Supplier;

public class Ex9 {

	public static void main(String[] args) {

		Supplier<String> supplier = () -> {
			return "hello";
		};

		// if i need greet message
		String message = supplier.get();
		System.out.println(message);

	}

}
