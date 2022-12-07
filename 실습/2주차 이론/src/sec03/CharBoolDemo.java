package sec03;

public class CharBoolDemo {

	public static void main(String[] args) {
		char ga1 = '가';
		char ga2 = '\uac00'; // 0
		boolean cham = true;
		boolean geojit = false;

		System.out.println(ga1);
		System.out.println(ga2);
		System.out.println(cham + "가 아니면 " + geojit + "입니다.");
		// + 는 공백없이 붙어서 출력됨

		String str = cham + "가 아니면 " + geojit + "입니다.";
		System.out.println(str);
	}

}