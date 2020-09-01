package examples;

import java.util.function.IntUnaryOperator;

public class Ex4 {

	public static void main(String[] args) {

		/*
		 * e.g
		 * 
		 * x =10
		 * 
		 * f= x+1 g= x*10
		 * 
		 * g(f()) = 110 f(g()) = 101
		 * 
		 * 
		 */

		int x = 10;

		IntUnaryOperator f = n -> n + 1;
		IntUnaryOperator g = n -> n * 10;

	
		// HOF
		
		IntUnaryOperator gf=f.andThen(g);
		System.out.println(gf.applyAsInt(x));
		
		IntUnaryOperator fg=f.compose(g);
		System.out.println(fg.applyAsInt(x));

	}

}
