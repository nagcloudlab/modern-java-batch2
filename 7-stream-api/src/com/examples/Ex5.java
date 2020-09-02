package com.examples;

import java.util.List;
import java.util.stream.Stream;

import com.model.Dish;

public class Ex5 {

	public static void main(String[] args) {

		List<Dish> menu = Dish.menu;
		
		// pipline ==> build -> intermediate-oprn(s) --> terminal
		
		Stream<String> stream=
		menu
		.stream()   // step-1 : build stream
		// step-2 : compose with intermediate operation 
		.filter(dish->{
			System.out.println("filtering -> "+dish);
			return dish.isVegetarian();
		})
		.map(dish->{
			System.out.println("mapping -> "+dish);
			return  String.format("%s : %d", dish.getName(),dish.getCalories());
		})
		.limit(2);
		
		
		
		stream
		.forEach(System.out::println);
		
		
//		stream
//		.forEach(System.out::println); // Illegal state exception

	}

}
