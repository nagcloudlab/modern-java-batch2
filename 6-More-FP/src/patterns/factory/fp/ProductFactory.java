package patterns.factory.fp;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import patterns.factory.Bond;
import patterns.factory.Loan;
import patterns.factory.Product;
import patterns.factory.Stock;

public class ProductFactory {

	final static Map<String, Supplier<Product>> map = new HashMap<>();

	static {
		map.put("loan", Loan::new);
		map.put("bond", Bond::new);
		map.put("stock", Stock::new);
	}

	public static Product getProduct(String name) {
		Supplier<Product> supplier = map.get(name);
		if (supplier != null)
			return supplier.get();
		throw new IllegalArgumentException("No such product");
	}

}
