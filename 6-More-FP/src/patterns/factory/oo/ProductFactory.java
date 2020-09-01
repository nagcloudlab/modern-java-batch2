package patterns.factory.oo;

import patterns.factory.Bond;
import patterns.factory.Loan;
import patterns.factory.Product;
import patterns.factory.Stock;

public class ProductFactory {

	public static Product getProduct(String name) {
		switch (name) {
		case "loan": {
			return new Loan();
		}
		case "stock": {
			return new Stock();
		}
		case "bond": {
			return new Bond();
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + name);
		}
	}

}
