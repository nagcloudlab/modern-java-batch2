package examples;

import java.util.function.Function;
import java.util.function.UnaryOperator;

class Employee {
	private String name;

	public Employee(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

public class Ex5 {

	public static void main(String[] args) {

		Employee employee = new Employee("nag");

		Function<Employee, String> getName = e -> e.getName();
		Function<String, Character> getFirstLetter = name -> name.charAt(0);
		UnaryOperator<Character> getCapitalInitial = c -> Character.toUpperCase(c);

		Function<Employee, Character> getIntial = 
				                                 getName
				                                 .andThen(getFirstLetter)
				                                 .andThen(getCapitalInitial);

		System.out.println(getIntial.apply(employee));

	}

}
