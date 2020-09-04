package com;

import io.reactivex.rxjava3.core.Observable;

class Product {
	private int id;
	private String name;

	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

}

//----------------------------------------------
// data layer
//----------------------------------------------

interface ProductRepository {
	Observable<Product> findProduct(int id);
}

class JpaProductRepository implements ProductRepository {
	@Override
	public Observable<Product> findProduct(int id) {
		return Observable.create(e -> {
			// ..
			// SQL
			Product product = new Product(id, "PRODUCT");
			e.onNext(product);
		});
	}
}

//----------------------------------------------
//service layer
//----------------------------------------------

class ProductService {
	ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Observable<Product> getProduct() {
		return productRepository.findProduct(1);
	}
}

//----------------------------------------------
//web/UI layer
//----------------------------------------------

class ProductController {
	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	public void get() {

		productService.getProduct() // non-blocking
				.subscribe(product -> {
					System.out.println(product);
				});
	}
}

public class Ex3 {

	public static void main(String[] args) {
		ProductController pc = new ProductController(new ProductService(new JpaProductRepository()));
		pc.get();
	}

}
