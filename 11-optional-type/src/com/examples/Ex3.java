package com.examples;

import java.util.Optional;

/*
 * 
 *  Person
 *  
 *  	Car
 *  
 *        Insurance
 * 
 */

class Insurance {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Car {

//	private Insurance insurance = null;
//
//	public Insurance getInsurance() {
//		return insurance;
//	}
//
//	public void setInsurance(Insurance insurance) {
//		this.insurance = insurance;
//	}
	
	private Optional<Insurance> insurance=Optional.empty(); // empty container

	public Optional<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(Optional<Insurance> insurance) {
		this.insurance = insurance;
	}
	
	
	

}

class Person {

//	private Car car = null;
//
//	public Car getCar() {
//		return car;
//	}
//
//	public void setCar(Car car) {
//		this.car = car;
//	}

	private Optional<Car> car=Optional.empty(); // empty container

	public Optional<Car> getCar() {
		return car;
	}

	public void setCar(Optional<Car> car) {
		this.car = car;
	}

}

public class Ex3 {

	public static String getCarInsuranceName(Optional<Person> person) {
		
//		return person.getCar().getInsurance().getName(); ///

		// --------------------------------------------------
//		if (person != null) {
//			Car car = person.getCar();
//			if (car != null) {
//				Insurance insurance = car.getInsurance();
//				if (insurance != null) {
//					return insurance.getName();
//				}
//			}
//		}
//		return "UNKNOWN";

		// --------------------------------------------------

//		if (person == null)
//			return "Unknown";
//
//		Car car = person.getCar();
//		if (car == null)
//			return "Unknown";
//
//		Insurance insurance = car.getInsurance();
//		if (insurance == null)
//			return "Unknown";
//
//		return insurance.getName();

		// --------------------------------------------------
		
		
		
		return 
		person
		.filter(p->true)
		.flatMap(Person::getCar)
		.flatMap(Car::getInsurance)
		.map(Insurance::getName)
		.orElse("Unknown");
		
		

	}

	public static void main(String[] args) {

		Insurance insurance = new Insurance();
		insurance.setName("INSURANCE");

		Car car = new Car();
//		car.setInsurance(insurance);
		car.setInsurance(Optional.of(insurance));

		Person person = new Person();
//		person.setCar(car);
		person.setCar(Optional.of(car));

		// -----------------------------------------------

		String insuranceName = getCarInsuranceName(Optional.of(person));
		System.out.println(insuranceName);

		// -----------------------------------------------

	}

}
