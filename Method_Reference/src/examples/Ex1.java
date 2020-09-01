package examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 
 *  Method Reference is like function pointer in C, C++
 *  
 *  
 *  why we need Method Reference ?
 *  
 *  
 *  	=> to use existing java method(s) as functions without Lambda-Expression
 * 
 */

class FoodUtil {
	public static boolean isVeg(String item) {
		return item.equals("veg");
	}
}

public class Ex1 {

	public static void main(String[] args) {

		List<String> menu = new ArrayList<String>();
		menu.add("veg");
		menu.add("veg");
		menu.add("non-veg");
		menu.add("veg");
		menu.add("veg");
		menu.add("non-veg");
		menu.add("veg");
		menu.add("non-veg");
		menu.add("veg");

		// -----------------------------------------
		// imperative style
		// -----------------------------------------
//		Iterator<String> iterator = menu.iterator();
//		while (iterator.hasNext()) {
//			String item = (String) iterator.next();
//			if (FoodUtil.isVeg(item))
//				iterator.remove();
//		}
//		System.out.println(menu);

		// -----------------------------------------
		// declarative/functional style
		// -----------------------------------------
//		menu.removeIf(item->item.equals("veg"));
//		menu.removeIf(item -> FoodUtil.isVeg(item)); 
		menu.removeIf(FoodUtil::isVeg); // MR => Method Reference
		System.out.println(menu);

	}

}
