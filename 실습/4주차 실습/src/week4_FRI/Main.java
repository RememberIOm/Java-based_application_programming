package week4_FRI;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("*�� �̿��Ͽ� ����� ����� �Է��ϼ���.");
		System.out.println("1: �������� ġ��ģ �Ʒ����� ū �ﰢ��");
		System.out.println("2: ���������� ġ��ģ �Ʒ����� ū �ﰢ��");
		System.out.println("3: ���ܿ��� ���ϴ� �κ��� ����ִ� ���簢��");
		System.out.println("�̿��� �Է��� ��� ����.");
		int type = in.nextInt(), line;
		
		while(type>=1 && type<=3){
			System.out.print("����� ���� ������ �Է��ϼ��� : ");	line=in.nextInt();
			printStar(type,line);
			
			System.out.println("*�� �̿��Ͽ� ����� ����� �Է��ϼ���.");
			System.out.println("1: �������� ġ��ģ �Ʒ����� ū �ﰢ��");
			System.out.println("2: ���������� ġ��ģ �Ʒ����� ū �ﰢ��");
			System.out.println("3: ���ܿ��� ���ϴ� �κ��� ����ִ� ���簢��");
			System.out.println("�̿��� �Է��� ��� ����.");
			type = in.nextInt();
		}
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}
	
	public static void printStar(int type, int line){
		switch(type){
		case 1:
			for (int i = 0; i < line; ++i) {
				for (int j = 0; j < i + 1; ++j) {
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 2:
			for (int i = 0; i < line; ++i) {
				for (int j = 0; j < line - i - 1; ++j) {
					System.out.print(" ");
				}
				for (int j = 0; j < i + 1; ++j) {
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 3:
			for (int i = 0; i < line; ++i) {
				for (int j = 0; j < line; ++j) {
					if (i + j != line - 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}

			System.out.println();
			break;
		default:
			System.out.println();
		}
	}
}