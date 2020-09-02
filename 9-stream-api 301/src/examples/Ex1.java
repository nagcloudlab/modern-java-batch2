package examples;

import java.util.List;

import com.model.Dish;

// Numeric streams

public class Ex1 {

	public static void main(String[] args) {

		List<Dish> menu = Dish.menu;

//		int totalCalories=menu
//		.stream()
//		.map(Dish::getCalories)
//		.reduce(0,(acc,c)->acc+c);
//		
//		System.out.println(totalCalories);
		
		
		// Numeric Streams
		
		System.out.println(
		
		menu.stream()
		.mapToInt(Dish::getCalories) // NUmeric streams
		//.sum()
		//.average()
		//.max()
		//.min()
		.summaryStatistics()
		
		);
		
		
	}

}
