package patterns.observer.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

enum Type {
	OPEN, CLOSE
}

class DoorEvent {
	Type type;
}

@FunctionalInterface
interface DoorListener {
	public void toggle(DoorEvent doorEvent);
}

//Open closed Principle
class Door {
	private List<DoorListener> doorListeners = new ArrayList<DoorListener>();

	public void addDoorListener(DoorListener doorListener) {
		this.doorListeners.add(doorListener);
	}

	public void removeListener(DoorListener doorListener) {
		this.doorListeners.remove(doorListener);
	}

	public void open() {
		System.out.println("door opened");
		DoorEvent doorEvent = new DoorEvent();
		doorEvent.type = Type.OPEN;
		doorListeners.forEach(listener -> listener.toggle(doorEvent));
	}

	public void close() {
		System.out.println("door closed");
		DoorEvent doorEvent = new DoorEvent();
		doorEvent.type = Type.CLOSE;
		doorListeners.forEach(listener -> listener.toggle(doorEvent));
	}
}

public class App {

	public static void main(String[] args) throws InterruptedException {

		Door door = new Door(); // observable

		DoorListener light = doorEvent -> {
			if (doorEvent.type.equals(Type.OPEN))
				System.out.println("light ON");
			if (doorEvent.type.equals(Type.CLOSE))
				System.out.println("light OFF");
		};
		DoorListener ac = doorEvent -> {
			if (doorEvent.type.equals(Type.OPEN))
				System.out.println("ac ON");
			if (doorEvent.type.equals(Type.CLOSE))
				System.out.println("ac OFF");
		};
		door.addDoorListener(light);
		door.addDoorListener(ac);

		TimeUnit.SECONDS.sleep(3);
		door.open();
		TimeUnit.SECONDS.sleep(3);
		door.close();

	}

}
