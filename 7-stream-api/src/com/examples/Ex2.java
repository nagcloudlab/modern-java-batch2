package com.examples;

import static java.util.Comparator.comparing;
import java.util.List;
import java.util.stream.Collectors;

import com.model.Dish;

public class Ex2 {

	public static void main(String[] args) {

		// JDK 1.8
		// get Low calorie dish names in asc
		
		List<Dish> menu = Dish.menu;
		
		
//		menu
//		.stream()
//		.filter(dish->dish.getCalories()<400)
//		.sorted((o1,o2)->Integer.compare(o1.getCalories(), o1.getCalories()))
//		.map(dish->dish.getName())
//		.forEach(name->System.out.println(name));
//		
		
		
//		menu  
//		.stream()
//		.parallel()
//		.filter(dish->dish.getCalories()<400)
//		.sorted(comparing(Dish::getCalories))
//		.map(Dish::getName)
//		.forEach(System.out::println);
		
		
		List<String> dietMenu=
		menu  
		.stream()
		.parallel()
		.filter(dish->dish.getCalories()<400)
		.sorted(comparing(Dish::getCalories))
		.map(Dish::getName)
		.collect(Collectors.toList());
		
		System.out.println(dietMenu);

		
	}

}
