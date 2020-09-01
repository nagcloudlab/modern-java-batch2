package examples;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/*
 * 
 *  why we need lambda expression?
 *  
 *  reason-3 : for lazy computation
 * 
 */

public class Ex8 {

	public static void main(String[] args) {

		String s1 = "hello";
		String s2 = null;

		computeHashing(s1, s2);

	}

	private static String getCurrentApplicationState() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return LocalDateTime.now().toString();
	}

	private static String createErrorMessage(String s) {
		// 0s
		return s + " cannot be null - " + getCurrentApplicationState();
	}

	private static void computeHashing(String s1, String s2) {

//		Objects.requireNonNull(s1, createErrorMessage("s1"));  // Eager
//		Objects.requireNonNull(s2, createErrorMessage("s2"));

		Objects.requireNonNull(s1, () -> createErrorMessage("s1"));
		Objects.requireNonNull(s2, () -> createErrorMessage("s2"));

		int hash = s1.hashCode() ^ s2.hashCode();
		System.out.println(hash);
	}

}
