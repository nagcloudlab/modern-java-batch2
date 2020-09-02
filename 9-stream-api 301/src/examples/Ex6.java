package examples;

import java.util.List;
import static java.util.stream.Collectors.*;

import com.model.Dish;

enum CaloricLevel {
	DIET, NORMAL, FAT
}

public class Ex6 {

	public static void main(String[] args) {

		List<Dish> menu = Dish.menu;

//		System.out.println(
//				menu.stream().collect(groupingBy(Dish::getType))
//		);

		// ---------------------------------------------------
		
//		System.out.println(
//		
//		menu.stream()
//		.collect(groupingBy(dish->{
//			if(dish.getCalories()<=400)return CaloricLevel.DIET;
//			else if(dish.getCalories()<=700)return CaloricLevel.NORMAL;
//			else return CaloricLevel.FAT;
//		}))
//		
//		);
		
		// ---------------------------------------------------
		
//		System.out.println(
//				menu.stream()
//				.collect(groupingBy(Dish::getType,mapping(Dish::getCalories, toList())))
//		);
//		
		
		// ---------------------------------------------------
		
//		System.out.println(
//		
//				menu.stream()
//				.collect(groupingBy(Dish::getType,flatMapping(dish -> Dish.dishTags.get(dish.getName()).stream(), toSet())))
//				
//		);
		
		// ---------------------------------------------------
		
//		System.out.println(
//		
//				menu.stream()
//				.collect(
//				        groupingBy(Dish::getType,
//				            filtering(dish -> dish.getCalories() > 500, toList())))
//				
//		);
//		
		//--------------------------------------------------
		
//		System.out.println(
//				
//		menu.stream()
//		.collect(
//		        groupingBy(Dish::getType,
//		            groupingBy((Dish dish) -> {
//		              if (dish.getCalories() <= 400) {
//		                return CaloricLevel.DIET;
//		              }
//		              else if (dish.getCalories() <= 700) {
//		                return CaloricLevel.NORMAL;
//		              }
//		              else {
//		                return CaloricLevel.FAT;
//		              }
//		            })
//		        )
//		    )
//		
//		);
		
		//--------------------------------------------------
//		
//		System.out.println(
//		
//				menu.stream().collect(groupingBy(Dish::getType, counting()))
//
//		);
		
		//--------------------------------------------------
		
		System.out.println(
		
			menu.stream().collect(
			        groupingBy(Dish::getType,
			            reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)))
				
		);
		
		
		
		
	}

}
