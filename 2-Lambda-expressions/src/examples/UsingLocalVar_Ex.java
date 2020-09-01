package examples;

import java.util.function.Consumer;

/*
 * 
 * imp-Note:
 * 
 *  Lambda expression can capture final local variables only
 * 
 */

public class UsingLocalVar_Ex {

	static String staVar = "static";
	String insVar = "instance";

	public static Consumer<String> getConsumerLambda() {

		// Thread-1
		String name = "Nag"; // Local variable

		Consumer<String> consumer = s -> {
			System.out.println(s + " " + name); // capture copy of local variable
			System.out.println(staVar);
		};

//		name = "Indu";

		return consumer;

	}

	public static void main(String[] args) {

		// Thread-2
		Consumer<String> consumer = getConsumerLambda();
		consumer.accept("hello");

	}

}
