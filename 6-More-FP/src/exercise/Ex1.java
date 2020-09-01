package exercise;

import java.util.function.Consumer;

/*
 * 
 *  design issues
 *  ---------------
 *   ==> code tangling/coupling
 *   ==> code scattering/duplication 
 *   
 *   
 *   solution: using higher-order function
 *   
 *   pattern : execute around 
 *   
 */

public class Ex1 {
	// HOF
	public static Consumer<String> withFlowerBanner(Consumer<String> consumer) {
		return name -> {
			System.out.println("🌹🌹🌹🌹🌹🌹🌹🌹🌹🌹");
			consumer.accept(name);
			System.out.println("🌹🌹🌹🌹🌹🌹🌹🌹🌹🌹");
		};
	}
	public static void main(String[] args) {
		// dev-1
		Consumer<String> hello = name -> {
			System.out.println("hello : " + name);
		};
		// dev-2
		Consumer<String> hi = name -> {
			System.out.println("hi : " + name);
		};
//		hello.accept("Nag");
//		hi.accept("Riya");
		Consumer<String> helloWithFlowerBanner = withFlowerBanner(hello);
		helloWithFlowerBanner.accept("Nag");
		Consumer<String> hiWithFlowerBanner = withFlowerBanner(hi);
		hiWithFlowerBanner.accept("Nag");
	}

}
