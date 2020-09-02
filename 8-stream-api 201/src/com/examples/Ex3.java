package com.examples;

import java.util.List;

import com.model.Dish;

/*
 * 
 * how to find & match elements in stream ?
 * 
 * 
 * 	- findFirst
 *  - findAny
 *  - anyMatch
 *  - noneMatch
 *  - allMatch
 * 
 * 
 * 
 */
public class Ex3 {
	
	public static void main(String[] args) {
		
		
		List<Dish> menu=Dish.menu;
		
		
		System.out.println(
				
				menu.stream()
				//.allMatch(dish->dish.getCalories()<1000)
				//.noneMatch(d->d.getCalories()>=1000)
				//.anyMatch(d->d.getCalories()<500)
				//.filter(Dish::isVegetarian)
				//.findAny()
				
		);
		
		
	}

}
