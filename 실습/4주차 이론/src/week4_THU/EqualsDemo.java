package week4_THU;

import java.util.Scanner;

public class EqualsDemo {

	public static void main(String[] args) {
		String str = "abc";
		String str2 = "abc";
		try (Scanner s = new Scanner(System.in)) {
			System.out.println(str == str2);
			str2 = s.next();
		}
		System.out.println(str == str2);
		System.out.println(str.equals(str2));
	}

}
