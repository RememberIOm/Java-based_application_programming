package sec03;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		// 자동완성 Ctrl + Space
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		System.out.printf("%d * %d은 %d입니다.\n", x, y, x * y);

	}

}