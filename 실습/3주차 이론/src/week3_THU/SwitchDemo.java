package week3_THU;

import java.util.Scanner;

public class SwitchDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		switch (input) {
		case 1:
			System.out.println("*");
			break;
		case 2:
			System.out.println("**");
			break;
		case 3:
			System.out.println("***");
			break;
		case 4:
			System.out.println("****");
			break;
		case 5:
			System.out.println("*****");
			break;
		case 6:
			System.out.println("******");
			break;
		case 7:
			System.out.println("*******");
			break;
		case 8:
			System.out.println("********");
			break;
		case 9:
			System.out.println("*********");
			break;
		case 10:
			System.out.println("**********");
			break;
		}
	}
}