package examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Consumer;

public class Ex6 {

	public static void main(String[] args) throws IOException {

		PrintWriter pw = new PrintWriter("log.txt");

		Consumer<String> consoleLogger = log -> System.out.println(log);
		Consumer<String> fileLogger = log -> {
			pw.print(log);
			pw.flush();
		};
		
		
		Consumer<String> logger=consoleLogger
				               .andThen(fileLogger);

		
		//--------------------------------------------------------
		
		
		logger.accept("started");
		
		//--------------------------------------------------------
		
	}

}
