package com.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.model.Dish;

/*
 * 
 *  design & performance issues
 *  ---------------------------
 *  
 *  => imperative style
 *  => verbose
 *  
 *  => many mutable  variables
 *  => sequential processing
 *  => difficult to apply concurrent/parallel execution
 * 
 */

public class Ex1 {

	public static void main(String[] args) {
		
		// JDK 1.7
		// get Low calorie dish names in asc

		List<Dish> menu = Dish.menu;

		
		// step-1
		List<Dish> lowCalorieDishes = new ArrayList<>();
		for (Dish dish : menu) {
			if (dish.getCalories() < 400)
				lowCalorieDishes.add(dish);
		}
		// step-2
		lowCalorieDishes.sort(new Comparator<Dish>() {
			@Override
			public int compare(Dish o1, Dish o2) {
				return Integer.compare(o1.getCalories(), o2.getCalories());
			}
		});
		// step-3
		List<String> lowCalorieDishNames = new ArrayList<>();
		for (Dish dish : lowCalorieDishes) {
			lowCalorieDishNames.add(dish.getName());
		}
		// step-4
		for (String name : lowCalorieDishNames) {
			System.out.println(name);
		}

	}

}
