package examples;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Runnable runnableTask = () -> {
			System.out.println(Thread.currentThread() + " executing runnable task");
		};

		Thread thread1 = new Thread(runnableTask);
		thread1.start();

		// -------------------------------------------------

		Callable<String> callableTask = () -> {
			System.out.println(Thread.currentThread() + " executing callable task");
			return "hello";
		};

		ExecutorService executorService = Executors.newFixedThreadPool(8);
		Future<String> future = executorService.submit(callableTask);
		String message = future.get();
		System.out.println(message);

		// -------------------------------------------------

		Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);

		// ---------------------------------------------------

	}

}
