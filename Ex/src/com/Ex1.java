package com;

import java.util.HashMap;
import java.util.Map;

public class Ex1 {

	public static void main(String[] args) {

		String[] report = 
			{ "A,IT,100", 
			  "B,IT,100",
			  "C,HR,100",
			  "D,IT,100",
			  "E,HR,100",
			  "F,MKT,100" };

		// ----------------------------------------------------
		// imperative style
		// ----------------------------------------------------

		Map<String, Double> depAndSalary = new HashMap<String, Double>();

		for (String line : report) {
			String[] tokens = line.split(",");
			String dep = tokens[1];
			double salary = Double.parseDouble(tokens[2]);
			if (depAndSalary.containsKey(dep))
				depAndSalary.put(dep, depAndSalary.get(dep) + salary);
			else
				depAndSalary.put(dep, salary);
		}

		System.out.println(depAndSalary);

	}

}
