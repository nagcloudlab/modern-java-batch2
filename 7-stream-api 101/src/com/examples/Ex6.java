package com.examples;

import java.util.List;
import java.util.stream.Collectors;

import com.model.Dish;

public class Ex6 {

	public static void main(String[] args) {

		List<Dish> menu = Dish.menu;

		
		List<String> threeHightCaloricDishNames=
				menu
				.stream()
				.filter(dish->dish.getCalories()>300)
				.map(Dish::getName)
				.limit(3)
				.collect(Collectors.toList());
		
		System.out.println(threeHightCaloricDishNames);
				
		
	}

}
