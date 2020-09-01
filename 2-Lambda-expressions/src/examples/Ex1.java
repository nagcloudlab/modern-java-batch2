package examples;

@FunctionalInterface
interface Predicate {
	boolean test(String s); // function descriptor
}

public class Ex1 {

	public static void main(String[] args) {

		Predicate f = (String s) -> {
			boolean result = s.isEmpty();
			return result;
		};

		f = (s) -> {
			boolean result = s.isEmpty();
			return result;
		};

		f = s -> {
			boolean result = s.isEmpty();
			return result;
		};

		f = s -> s.isEmpty();

		f = s -> true;

		boolean b = f.test("");
		System.out.println(b);

	}

}
