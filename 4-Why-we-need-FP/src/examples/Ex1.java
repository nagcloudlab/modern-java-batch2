package examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 
 *  why we need lambda expression?
 *  
 *  reason-1 : compact & concise code
 * 
 */

public class Ex1 {

	public static void main(String[] args) {

		List<String> menu = new ArrayList<String>();
		menu.add("veg");
		menu.add("non-veg");
		menu.add("non-veg");
		menu.add("veg");
		menu.add("veg");
		menu.add("non-veg");
		menu.add("veg");
		menu.add("non-veg");

		// ---------------------------------------------
		// imperative style
		// ---------------------------------------------

		Iterator<String> iterator = menu.iterator();
		while (iterator.hasNext()) {
			String item = iterator.next();
			if (item.equals("non-veg"))
//				menu.remove(item);  // this line leads to CocurrentModificationException
				iterator.remove();
		}
//
//		System.out.println(menu);

		// ---------------------------------------------
		// declarative / functional style ==> behva parameterization
		// ---------------------------------------------

		menu.removeIf(item -> item.equals("non-veg"));
//		menu.removeIf(item->item.equals("veg"));

		System.out.println(menu);

	}

}
