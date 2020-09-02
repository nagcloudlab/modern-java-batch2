package examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
 * 
 *   stream from IO source
 * 
 */

public class Ex4 {
	
	public static void main(String[] args) throws IOException {
		
		
		Path path = Paths.get("data.txt");
		Stream<String> streamOfStrings = Files.lines(path); // IO stream
		streamOfStrings
		.map(Integer::parseInt)
		.map(n->n*n)
		.forEach(System.out::println);
		
		
	}

}
