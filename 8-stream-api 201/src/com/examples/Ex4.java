package com.examples;

import java.util.Comparator;
import java.util.List;

import com.model.Dish;

/*
 * 
 * -> how to fold/reducing items in stream
 * 
 * 
 * 	 - reduce
 *   - min
 *   - max
 *   - count
 * 
 * 
 */
public class Ex4 {
	
	public static void main(String[] args) {
		
		
		List<Dish> menu=Dish.menu;
		
		
		System.out.println(
				
				menu.stream()
				//.map(Dish::getCalories)
				//.reduce(0,(acc,c)->acc+c)
				//.min(Comparator.comparing(Dish::getCalories))
				//.max(Comparator.comparing(Dish::getCalories))
				.count()
				
				
				
		);
		
		
	}

}
