package com.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.model.Dish;

/*
 * 
 * how to filter items with stream ?
 * 
 * 
 * From JDK 1.8
 * 
 * 	- filter   
 *  - limit
 *  - skip
 *  - distinct
 *  
 * From JDK 1.9
 *  
 *  - takeWhile
 *  - dropWhile
 * 
 * 
 */

class Product {

	private String name;

	public Product(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}

public class Ex1 {

	public static void main(String[] args) {

		List<Dish> menu = Dish.menu;

		// ------------------------------------------------------
		// filter
		// ------------------------------------------------------

//		List<Dish> vegeterianDishes=new ArrayList<Dish>();
//		for(Dish dish:menu) {
//			if(dish.isVegetarian())
//				vegeterianDishes.add(dish);
//		}

		List<Dish> vegeterianDishes = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

		// ------------------------------------------------------
		// Filter Unique Elements : distinct
		// ------------------------------------------------------
		
//		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4,5);
//		
//		numbers
//		.stream()
//		.filter(n -> n % 2 == 0)
//		.distinct()
//		.forEach(System.out::println);
//		
//		List<Product> products=List.of(new Product("item-1"),new Product("item-2"),new Product("item-1"));
//		
//		products
//		.stream()
//		.distinct()
//		.forEach(System.out::println);
//		
		//------------------------------------------------------
		// Limit
		//------------------------------------------------------
		
//		numbers
//		.stream()
//		.filter(n -> n % 2 != 0)
//		.distinct()
//		.limit(2)
//		.forEach(System.out::println);
		
		
		//------------------------------------------------------
		 // TakWhile & DropWhile
		//------------------------------------------------------
		
		List<Dish> specialMenu = Arrays.asList(
				new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER));
		
		
		
		List<Dish> filteredMenu=
				specialMenu
				.stream()
				//.filter(dish->dish.getCalories()<320)
				.takeWhile(dish->dish.getCalories()<320)
				//.dropWhile(dish->dish.getCalories()<320)
				.collect(Collectors.toList());
		
		System.out.println(filteredMenu);
		
		
		

	}
}
