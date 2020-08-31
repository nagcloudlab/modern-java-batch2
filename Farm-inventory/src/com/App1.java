package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.model.Apple;
import com.model.Color;

public class App1 {

	public static void main(String[] args) {

	  List<Apple> inventory = Arrays.asList(
		        new Apple(80, Color.GREEN),
		        new Apple(155, Color.GREEN),
		        new Apple(120, Color.RED));
	  
	  
	  System.out.println(
			  
//			  filterGreenApples(inventory)
//			  filterRedApples(inventory)
			  
//			  filterApplesByColor(inventory, Color.GREEN)
//			  filterApplesByColor(inventory, Color.RED)
			  
//			  filterApplesByWeight(inventory, 150)
			  
//			  filterApples(inventory, Color.GREEN, 0, true)
//			  filterApples(inventory, null, 150, false)
			  
			  
//			  filterApples(inventory, new GreenApplePredicate())
//			  filterApples(inventory, new HeavyApplePredicate())
			  
			  
			  //#5 behavior parameterization thru Anonymous inner class 
			  
//			  filterApples(inventory, new ApplePredicate() {
//				  @Override
//				public boolean test(Apple apple) {
//					return apple.getColor().equals(Color.GREEN);
//				}
//			  })
			  
//			  filterApples(inventory, new ApplePredicate() {
//				  @Override
//				public boolean test(Apple apple) {
//					return apple.getColor().equals(Color.RED);
//				}
//			  })
			  
			//#6 behavior parameterization thru Lambda Expression ( java - 8 )
			  
//			 filterApples(inventory, (Apple apple)->{
//				 return apple.getColor().equals(Color.GREEN);
//			 }) 
			  
//			 filterApples(inventory, (apple)->{
//				 return apple.getColor().equals(Color.GREEN);
//			 })  
			  
//			  filterApples(inventory, apple->{
//					 return apple.getColor().equals(Color.GREEN);
//			  })  
			  
			  
//			  filterApples(inventory, apple->apple.getColor().equals(Color.GREEN))
//			  filterApples(inventory, apple->apple.getColor().equals(Color.RED))
//			  filterApples(inventory, apple->apple.getWeight()>150)
			  filterApples(inventory, apple->apple.getColor().equals(Color.RED) && apple.getWeight()>150)
			  			  
			  
	 );
		
	}
	
	
	//#4 ==> behavior parameterization
	public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate predicate) {
		List<Apple> out=new ArrayList<Apple>();
		for(Apple apple:inventory) {
			if(predicate.test(apple))
				out.add(apple);
		}
		return out;
	}
	
	
	//------------------------------------------------------------------------------
	
	//#3
	public static List<Apple> filterApples(List<Apple> inventory,Color color,int weight,boolean flag) {
		List<Apple> out=new ArrayList<Apple>();
		for(Apple apple:inventory) {
			if(flag && apple.getColor().equals(color) )
				out.add(apple);
			if(!flag && apple.getWeight()>weight) 
				out.add(apple);
		}
		return out;
	}
	
	//------------------------------------------------------------------------------
	
	//#2
	public static List<Apple> filterApplesByColor(List<Apple> inventory,Color color) {
		List<Apple> out=new ArrayList<Apple>();
		for(Apple apple:inventory) {
			if(apple.getColor().equals(color))
				out.add(apple);
		}
		return out;
	}
	public static List<Apple> filterApplesByWeight(List<Apple> inventory,int weight) {
		List<Apple> out=new ArrayList<Apple>();
		for(Apple apple:inventory) {
			if(apple.getWeight() > 150)
				out.add(apple);
		}
		return out;
	}
	
	//------------------------------------------------------------------------------
	
	//#1
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> out=new ArrayList<Apple>();
		for(Apple apple:inventory) {
			if(apple.getColor().equals(Color.GREEN))
				out.add(apple);
		}
		return out;
	}
	public static List<Apple> filterRedApples(List<Apple> inventory) {
		List<Apple> out=new ArrayList<Apple>();
		for(Apple apple:inventory) {
			if(apple.getColor().equals(Color.RED))
				out.add(apple);
		}
		return out;
	}

	//------------------------------------------------------------------------------

}
