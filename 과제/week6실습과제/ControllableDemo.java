package week6_FRI;

interface Controllable {
	default void repair() {
		System.out.println("��� �����Ѵ�.");
	}

	static void reset() {
		System.out.println("��� �ʱ�ȭ�Ѵ�.");
	}

	void turnOn();

	void turnOff();
}

class Computer implements Controllable {
	public void turnOn() {
		System.out.println("��ǻ�͸� �Ҵ�.");
	}

	public void turnOff() {
		System.out.println("��ǻ�͸� ����.");
	}
}

class TV implements Controllable {
	@Override
	public void turnOn() {
		System.out.println("TV�� �Ҵ�.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV�� ����.");
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
