package exercise;

import java.util.function.Consumer;

/*
 * 
 *  design issues
 *  ---------------
 *  
 *   ==> code tangling/coupling
 *   ==> code scattering/duplication 
 *   
 *   
 */

public class Ex1 {

	public static void main(String[] args) {

		Consumer<String> sayHello = name -> {
			System.out.println("🌺🌺🌺🌺🌺🌺🌺🌺🌺");
			System.out.println("hello :" + name);
			System.out.println("🌺🌺🌺🌺🌺🌺🌺🌺🌺");
		};

		Consumer<String> sayHi = name -> {
			System.out.println("🌺🌺🌺🌺🌺🌺🌺🌺🌺");
			System.out.println("hi :" + name);
			System.out.println("🌺🌺🌺🌺🌺🌺🌺🌺🌺");
		};

		sayHello.accept("Nag");
		sayHi.accept("Riya");

	}

}
