package sec03;

public class CharBoolDemo {

	public static void main(String[] args) {
		char ga1 = '��';
		char ga2 = '\uac00'; // 0
		boolean cham = true;
		boolean geojit = false;

		System.out.println(ga1);
		System.out.println(ga2);
		System.out.println(cham + "�� �ƴϸ� " + geojit + "�Դϴ�.");
		// + �� ������� �پ ��µ�

		String str = cham + "�� �ƴϸ� " + geojit + "�Դϴ�.";
		System.out.println(str);
	}

}