package examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * 
 * pattern : execute around 
 * 
 */

@FunctionalInterface
interface BufferedReaderProcessor {
	String process(BufferedReader br) throws IOException;
}

public class Example1 {

	public static void main(String[] args)throws IOException {

		System.out.println(

				//readTopics(br->br.readLine())
				//readTopics(br->br.readLine()+"\n"+br.readLine())
				readTopics(br->br.readLine()+"\n"+br.readLine()+"\n"+br.readLine())
		);

	}

	public static String readTopics(BufferedReaderProcessor bp)throws IOException {
		File file = new File("topics.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			return bp.process(br);
		}
	}

	public static String readOneTopic_v2()throws IOException {
		File file = new File("topics.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			return br.readLine(); // logic
		} 
	}

	public static String readOneTopic_v1() {
		File file = new File("topics.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file)); // init...
			return br.readLine(); // logic
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close(); // clean
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return null;
	}

}
