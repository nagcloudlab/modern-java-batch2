package com.examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.model.Dish;

/*
 * 
 * -> how to transform items in stream
 * 
 * 		- map
 *      - flatMap
 * 
 */

public class Ex2 {

	public static void main(String[] args) throws Exception {
		
		//--------------------------------------------------
		// Map
		//--------------------------------------------------

//		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//		
//		List<Integer> doubledNumbers=
//		numbers
//		.stream()
//		.map(n->n*n)
//		.collect(Collectors.toList());
//		
//		System.out.println(doubledNumbers);
//		
//		
//		List<Dish> menu=Dish.menu;
//		List<String> dishNames=
//				menu
//				.stream()
//				.map(dish->dish.getName())
//				.collect(Collectors.toList());
//		
//		System.out.println(dishNames);
		

		//--------------------------------------------------
		// flatMap
		//--------------------------------------------------
		
		
		/*
		 * 
		 *   1  2  3   
		 * 
		 *   1 1*1 1*1*1 2 2*2 2*2*2 3 3*3 3*3*
		 *   
		 *   1 1 1 2 4 8 3 9 27
		 */
		
		
//		List<Integer> integers=List.of(1,2,3);
//		
//		
//		
//		List<Integer> result=
//		integers
//		.stream()
//		.flatMap(n->Arrays.stream(new Integer[] {n,n*n,n*n*n}))
//		.distinct()
//		.collect(Collectors.toList());
//		
//		
//		result.forEach(ele->{
//			System.out.println(ele);
//		});
		
		
		//--------------------------------------------------------
		
		
//		
//		List<String> lines=new ArrayList<String>();
//		BufferedReader br=new BufferedReader(new FileReader("Notes.txt"));
//		String line=null;
//		while((line=br.readLine())!=null) {
//			lines.add(line);
//		}
//		br.close();
//		
//		long wordCount=
//		lines
//		.stream()
//		.flatMap(l->Stream.of(l.split(" ")))
//		.distinct()
//		.count();
//		
//		System.out.println(wordCount);
//		
		//---------------------------------------------------------
		
		
	}

}
