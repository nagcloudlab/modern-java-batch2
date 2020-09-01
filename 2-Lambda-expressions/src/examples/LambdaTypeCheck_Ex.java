package examples;

@FunctionalInterface
interface Joiner {
	String join(String s1, String s2);
}

interface Adder {
	int add(int n1, int n2);
}

class Lib {

	public static void testJoiner(Joiner joiner) {
		String result = joiner.join("hello", "world");
		System.out.println(result);
	}

	public static void testAdder(Adder adder) {
		int result = adder.add(12, 13);
		System.out.println(result);
	}

//	public static void test(Joiner joiner) {
//		String result = joiner.join("hello", "world");
//		System.out.println(result);
//	}
//
//	public static void test(Adder adder) {
//		int result = adder.add(12, 13);
//		System.out.println(result);
//	}

}

public class LambdaTypeCheck_Ex {

	public static void main(String[] args) {

		Lib.testJoiner((x, y) -> x + y);
		Lib.testAdder((x, y) -> x + y);

	}

}
