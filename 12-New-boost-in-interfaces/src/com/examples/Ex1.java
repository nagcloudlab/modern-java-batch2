package com.examples;

import java.util.Comparator;
import java.util.function.Predicate;

//-------------------------------------------

// custom collections
//-------------------------------------------

//-------------------------------------------
// Top-Level / Abstraction / Interface
//-------------------------------------------

// 15yrs back
interface Collection {
	
	// constant variables
	
	// no constructor
	
	void add(String ele);

	void clear();

	default boolean removeIf(Predicate<String> predicate) {
		// ...
		return true;
	}

}

interface List extends Collection {
	void add(int idx, String ele);
}

interface Set extends Collection {
}

//------------------------------------------



//-------------------------------------------
//Middle-Level / Encapsulation / Implementation
//-------------------------------------------

abstract class AbstractList implements List{
	
	// Mutable Variables
	
	// Constructor(s)
	
	@Override
	public void clear() {
		//..
	}
}


//-------------------------------------------
//Bottom-Level / Encapsulation / Implementation
//-------------------------------------------

//100 impln
class ArrayList extends AbstractList implements List {

	@Override
	public void add(String ele) {

	}

	@Override
	public void add(int idx, String ele) {
		// TODO Auto-generated method stub

	}


}

class LinkedList extends AbstractList implements List {

	@Override
	public void add(String ele) {

	}

	@Override
	public void add(int idx, String ele) {

	}

	
}

public class Ex1 {

	public static void main(String[] args) {

		List list = new ArrayList();
		list = new LinkedList();

		list.removeIf(s -> true);

		
		
		
		
		Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
		Comparator<String> reverseComparator = comparator.reversed();
		Comparator<String> nullsLastComparator=Comparator.nullsFirst(comparator);
		
		
		String s1="a";
		String s2=null;
		
		
		java.util.List<String> strings=new java.util.ArrayList<String>();
		strings.add("Nag");
		strings.add(null);
		strings.add("Indu");
		strings.add("Riya");
		strings.add("Diya");
		
		strings.sort(nullsLastComparator);
		
		System.out.println(strings);
		

	}

}
