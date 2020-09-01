package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import com.model.Apple;
import com.model.Color;

import static java.util.Comparator.comparing;

public class Ex3 {
	
	public static void main(String[] args) {
		
		
		 // 1
	    List<Apple> inventory = new ArrayList<>();
	    inventory.addAll(Arrays.asList(
	        new Apple(80, Color.GREEN),
	        new Apple(155, Color.GREEN),
	        new Apple(120, Color.RED)
	    ));
	    
	    // way-1 : lambda - syntax
//	    inventory.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
//	    System.out.println(inventory);
	    
	    //way-2 : method reference - syntax
//	    inventory.sort(comparing(apple->apple.getWeight()));
	    
//	    inventory.sort(comparing(Apple::getWeight));  // f(g(h()))
	    
	    Function<Apple, Integer> getWight=Apple::getWeight;
	    Comparator<Apple> byWeight=comparing(getWight);
	    inventory.sort(byWeight);
	    
	    System.out.println(inventory);
	    
		
		
	}

}
