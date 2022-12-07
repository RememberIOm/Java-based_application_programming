package week3_FRI;

import java.util.Scanner;

public class Report {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("������ �۾��� �����ϼ���. 1 : ������ ���. 2 : �� ���� x, y�� ���� x�� y�� ���� ������ ���.");
		int workInput = sc.nextInt();

		if (workInput == 1) {
			System.out.println("�� ���� ����Ͻǰǰ��� :");
			int timesNum = sc.nextInt();
			timesTable(timesNum);
		} else if (workInput == 2) {
			System.out.println("x�� �Է��ϼ��� :");
			int x = sc.nextInt();
			System.out.println("y�� �Է��ϼ��� :");
			int y = sc.nextInt();
			System.out.println("x�� y�� ���� �������� " + x % y + "�Դϴ�.");
		} else {
			System.out.println("�Է��� �߸� �Ǿ����ϴ�.");
		}
	}

	public static void timesTable(int input) {
		for (int i = 1; i < 10; ++i) {
			System.out.println(input + "*" + i + " = " + input * i);
		}
	}
}