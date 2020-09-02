package com.examples;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// custom data-structure / collection
class MyList<E> implements Iterable<E> {

	// Array | DLL | Tree | Graph | Hashtable

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}

class DataFactory {

	public static List<String> getStrings() {
		List<String> strings = List.of("a", "b", "c");
		return strings;
	}

	public static MyList<String> getMyList() {
		MyList<String> myList = new MyList<>();
		// ....
		return myList;
	}

}

public class Ex3 {

	public static void main(String[] args) {

		// your code

		Collection<String> strings = DataFactory.getStrings();

		// iteration logic by using index
//		for (int i = 0; i < strings.size(); i++) {
//			String string = strings.get(i);
//			System.out.println(string);
//		}

		Iterator<String> iterator = strings.iterator();
		while (iterator.hasNext()) {
			String string = iterator.next();
			System.out.println(string);
		}

		for (String string : strings) {
			System.out.println(string);
		}

		//

		MyList<String> myList = DataFactory.getMyList();
		for (String string : myList) {
		}

	}

}
