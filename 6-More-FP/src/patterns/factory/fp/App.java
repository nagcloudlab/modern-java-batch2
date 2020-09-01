package patterns.factory.fp;

import patterns.factory.Loan;
import patterns.factory.Product;
import patterns.factory.Stock;

public class App {

	public static void main(String[] args) {

		// -----------------------------------------
		// module-1
		// -----------------------------------------

		Product product = ProductFactory.getProduct("loan");
		System.out.println(product instanceof Loan);

		// -----------------------------------------
		// module-2
		// -----------------------------------------

		product = ProductFactory.getProduct("stock");
		System.out.println(product instanceof Stock);

	}

}
