package examples;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class Product {
	private int id;
	private String name;
	private String price;

	public Product(int id) {
		super();
		this.id = id;
	}

	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Product(int id, String name, String price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}

public class Ex2 {

	public static void main(String[] args) {

		// ------------------------------------------------------------
		// MR with instance method
		// ------------------------------------------------------------
		// Lambda
		Function<String, Integer> function1 = s -> s.length();
		System.out.println(function1.apply("NAG"));
		// MR
		Function<String, Integer> function2 = String::length;
		System.out.println(function2.apply("NAG"));
		// ------------------------------------------------------------

		// ------------------------------------------------------------
		// MR with static method
		// ------------------------------------------------------------

		// Lambda
		BiFunction<String, Integer, String> function3 = (s, n) -> String.format(s, n);
		System.out.println(function3.apply("then value is %d", 10));

		// MR
		BiFunction<String, Integer, String> function4 = String::format;
		System.out.println(function4.apply("then value is %d", 10));

		// ------------------------------------------------------------
		BiFunction<Integer, Integer, Integer> biFunction1 = (n1, n2) -> Integer.compare(n1, n2);
		BiFunction<Integer, Integer, Integer> biFunction2 = Integer::compare;

		// ------------------------------------------------------------

		Thread thread = Thread.currentThread();

		Supplier<String> supplier1 = () -> thread.getName();
		System.out.println(supplier1.get());

		Supplier<String> supplier2 = thread::getName;

		// --------------------------------------------------------------

		Function<Integer, Product> function11 = id -> new Product(id);
		Function<Integer, Product> function12 = Product::new;

		BiFunction<Integer, String, Product> function13 = (id, name) -> new Product(id, name);
		BiFunction<Integer, String, Product> function14 = Product::new;

		Product product = function14.apply(101, "LAPTOP");

		// ---------------------------------------------------------------

	}

}
