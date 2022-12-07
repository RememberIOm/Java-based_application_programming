package week6_FRI;

interface Controllable {
	default void repair() {
		System.out.println("장비를 수리한다.");
	}

	static void reset() {
		System.out.println("장비를 초기화한다.");
	}

	void turnOn();

	void turnOff();
}

class Computer implements Controllable {
	public void turnOn() {
		System.out.println("컴퓨터를 켠다.");
	}

	public void turnOff() {
		System.out.println("컴퓨터를 끈다.");
	}
}

class TV implements Controllable {
	@Override
	public void turnOn() {
		System.out.println("TV를 켠다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끈다.");
	}
}

public class ControllableDemo {

	public static void main(String[] args) {
		Controllable[] controllable = { new TV(), new Computer() };

		for (Controllable c : controllable) {
			c.turnOn();
			c.turnOff();
			c.repair();
		}
		Controllable.reset();

	}

}
