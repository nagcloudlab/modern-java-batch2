package examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.model.Apple;
import com.model.Color;

public class Ex3 {

	public static void main(String[] args) {

		// HOF/P
		
		 List<Apple> inventory = Arrays.asList(
			        new Apple(80, Color.GREEN,"INDIA"),
			        new Apple(80, Color.GREEN,"AUS"),
			        new Apple(120, Color.RED,"US"));
		 
		 
		Comparator<Apple> byWeightComparator=(a1,a2)->Integer.compare(a1.getWeight(), a2.getWeight()); 
		Comparator<Apple> byCountryComparator=(a1,a2)->a1.getCountry().compareTo(a2.getCountry());
		
//		Comparator<Apple> byWeightAndThenCountry=(a1,a2)->{
//			if(Integer.compare(a1.getWeight(), a2.getWeight())==0) {
//				return a1.getCountry().compareTo(a2.getCountry());
//			}else {
//				return Integer.compare(a1.getWeight(), a2.getWeight());
//			}
//		};
		
		// HOF
		
		Comparator<Apple> byWeightAndThenCountry=byWeightComparator.thenComparing(byCountryComparator);
		
		inventory.sort(byWeightAndThenCountry);
		
		
		inventory.forEach(item->System.out.println(item));

	}

}
