package examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// 

/*
 * 
 * 
 
 Principles of Functional Programming
   
 - A function can be stored in a variable or value i,e function is first-class citizen
 - A parameter of a function can be a function 
 - The return value of a function can be a function
 
 * 
 * 
 */

public class Ex3 {

	public static void main(String[] args) {

		Predicate<String> predicate = String::isEmpty;

		Predicate<String> inversePredicate = predicate.negate();

		List<String> menu = new ArrayList<String>();
		menu.add("veg");
		menu.add("non-veg");
		menu.add("non-veg");
		menu.add("veg");

		menu.replaceAll(item -> item.equals("non-veg") ? "*" : item);

		System.out.println(menu);

	}

}
