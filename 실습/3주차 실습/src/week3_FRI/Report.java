package week3_FRI;

import java.util.Scanner;

public class Report {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("수행할 작업을 선택하세요. 1 : 구구단 출력. 2 : 두 정수 x, y에 대한 x를 y로 나눈 나머지 출력.");
		int workInput = sc.nextInt();

		if (workInput == 1) {
			System.out.println("몇 단을 출력하실건가요 :");
			int timesNum = sc.nextInt();
			timesTable(timesNum);
		} else if (workInput == 2) {
			System.out.println("x를 입력하세요 :");
			int x = sc.nextInt();
			System.out.println("y를 입력하세요 :");
			int y = sc.nextInt();
			System.out.println("x를 y로 나눈 나머지는 " + x % y + "입니다.");
		} else {
			System.out.println("입력이 잘못 되었습니다.");
		}
	}

	public static void timesTable(int input) {
		for (int i = 1; i < 10; ++i) {
			System.out.println(input + "*" + i + " = " + input * i);
		}
	}
}