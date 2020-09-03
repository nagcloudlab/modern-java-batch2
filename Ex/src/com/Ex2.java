package com;

import java.util.Arrays;

import static java.util.stream.Collectors.*;

public class Ex2 {
	
	public static void main(String[] args) {
		
		String[] report = 
			{ "A,IT,100", 
			  "B,IT,100",
			  "C,HR,100",
			  "D,IT,100",
			  "E,HR,100",
			  "F,MKT,100" };

		// ----------------------------------------------------
		// declarative style using stream api
		// ----------------------------------------------------
		
		System.out.println(
		
		Arrays.stream(report)
		.map(line->line.split(","))
		.collect(groupingBy(tokens->tokens[1],mapping(tokens->Double.parseDouble(tokens[2]), reducing((n1,n2)->n1+n2))))
		
		);

		
	}

}
