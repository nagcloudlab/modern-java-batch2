package com;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Ex3 {

	public static void main(String[] args) throws IOException{

		Path path = Path.of("report.csv");
		
		Map<String,Double> depAndSalary=
		Files.lines(path)
		.map(line->line.split(","))
		.collect(
				groupingBy(tokens->tokens[1],
						mapping(tokens->Double.parseDouble(tokens[2]), 
								reducing(0.0,(n1,n2)->n1+n2))));

		
		System.out.println(depAndSalary);
		
	}

}
