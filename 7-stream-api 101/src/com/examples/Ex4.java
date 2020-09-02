package com.examples;

import java.util.List;

import com.model.Dish;

/*
 * 
 *  External vs Internal iteration
 * 
 * 
 * 
 *  limitations of external iteration over collection
 *  
 *   
 *   => imperative style
 *   => sequential execution
 *   => multiple temp mutable variables
 *   => difficult to apply concurrent/parallel execution
 *   
 *   
 */

public class Ex4 {

	public static void main(String[] args) {

		List<Dish> menu = Dish.menu;

		// external iteration
		for (Dish dish : menu) {
			System.out.println(dish);
		}
		
		System.out.println("-----------------------");

		// internal iteration
		menu
		.stream()
		.filter(Dish::isVegetarian)
		.forEach(System.out::println);
		

	}

}
