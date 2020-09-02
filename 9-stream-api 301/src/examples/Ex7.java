package examples;

import java.util.List;

import com.model.Dish;

import static java.util.stream.Collectors.*;

public class Ex7 {
	
	public static void main(String[] args) {
		
		List<Dish> menu = Dish.menu;
		
		System.out.println(
				//menu.stream().collect(partitioningBy(Dish::isVegetarian))
				menu.stream()
				.collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)))
		);
		
		
	}
	

}
