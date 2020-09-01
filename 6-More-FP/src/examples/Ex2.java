package examples;

/*
 * 
 *  Lambda-Expression vs Anonymous-Inner-class
 * 
 * 
 */

public class Ex2 {

	public static void main(String[] args) {

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("im running");
			}
		};
		runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("im running");
			}
		};
		runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("im running");
			}
		};
		
		
		

		runnable = () -> {
			System.out.println("im running");
		};
		runnable = () -> {
			System.out.println("im running");
		};
		runnable = () -> {
			System.out.println("im running");
		};

	}

}
