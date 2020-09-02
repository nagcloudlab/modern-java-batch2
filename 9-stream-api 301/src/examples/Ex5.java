package examples;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.model.Dish;

// how to collect data from  stream i.e collectors


/*
 * 
 *  3 types of collectors
 *  
 *  
 *  => reducing and summarizing stream elements to a single value
 *  => grouping elements
 *  => partitioning elements
 * 
 * 
 */

public class Ex5 {

	public static void main(String[] args) {

		List<Dish> menu = Dish.menu;

		// reducing & summarizing

		long howManyDishes = menu.stream().collect(Collectors.counting());
		// or
		howManyDishes = menu.stream().count();
		System.out.println(howManyDishes);

		Comparator<Dish> dishCalorieComparator = Comparator.comparing(Dish::getCalories);
		Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCalorieComparator));
		// or
		mostCalorieDish = menu.stream().max(dishCalorieComparator);
		System.out.println(mostCalorieDish);

		int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		// or
		totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println(totalCalories);

		double avgCalaories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
		System.out.println(avgCalaories);

		
		IntSummaryStatistics statistics=menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println(statistics);
		
		
		String str=menu.stream().map(Dish::getName).collect(Collectors.joining());
		
	}

}
