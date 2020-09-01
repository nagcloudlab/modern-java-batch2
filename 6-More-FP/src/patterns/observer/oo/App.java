package patterns.observer.oo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * 
 * design issues
 * ---------------
 * 
 * => subject & listeners are tight coupled
 * => violating 'open for extension & closed for modification' principle
 *  
 * 
 */

class DoorEvent {
}

interface DoorListener {
	void on(DoorEvent event);

	void off(DoorEvent event);
}

class Light implements DoorListener {
	public void on(DoorEvent event) {
		System.out.println("light ON");
	}

	public void off(DoorEvent event) {
		System.out.println("light OFF");
	}
}

class Fan implements DoorListener {
	public void on(DoorEvent event) {
		System.out.println("fan ON");
	}

	public void off(DoorEvent event) {
		System.out.println("fan OFF");
	}
}

class AC implements DoorListener {
	public void on(DoorEvent event) {
		System.out.println("ac ON");
	}

	public void off(DoorEvent event) {
		System.out.println("ac OFF");
	}
}

class Door {

//	Light light = new Light();
//	Fan fan = new Fan();
//	AC ac = new AC();

	private List<DoorListener> doorListeners = new ArrayList<DoorListener>();

	public void addDoorListener(DoorListener doorListener) {
		this.doorListeners.add(doorListener);
	}

	public void removeListener(DoorListener doorListener) {
		this.doorListeners.remove(doorListener);
	}

	public void open() {
		System.out.println("door opened...");
//		light.on();
//		fan.on();
//		ac.on();
		DoorEvent event = new DoorEvent();
		doorListeners.forEach(listener -> listener.on(event)); // notify..

	}

	public void close() {
		System.out.println("door closed...");
//		light.off();
//		fan.off();
//		ac.off();
		DoorEvent event = new DoorEvent();
		doorListeners.forEach(listener -> listener.off(event)); // notify..
	}
}

public class App {

	public static void main(String[] args) throws InterruptedException {

		Door door = new Door();

		DoorListener light = new Light();
		DoorListener fan = new Fan();
		DoorListener ac = new AC();

		door.addDoorListener(light);
		door.addDoorListener(fan);
		door.addDoorListener(ac);

		door.removeListener(ac);

		TimeUnit.SECONDS.sleep(3);
		door.open();
		TimeUnit.SECONDS.sleep(3);
		door.close();

	}

}
