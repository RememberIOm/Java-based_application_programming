package week4_THU;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String userInput = sc.nextLine();
		
		while (!userInput.equals("exit")) {
			if (userInput.equals("�ȳ�?")) {
				System.out.println("�ȳ�");
			} else if (userInput.equals("�̸��̹���?")) {
				System.out.println("���ؿ�");
			} else if (userInput.equals("���ó����¾?")) {
				System.out.println("���ͳ�����Ȯ���غ�");
			} else if (userInput.equals("�ڹٱ���������α׷��� ���� ���?")) {
				System.out.println("����־�");
			} else if (userInput.equals("���ݱ�������?")) {
				System.out.println("�������ʾ�");
			} else {
				System.out.println("�� �װ� �� �𸣰ھ�.");
			}
			
			userInput = sc.nextLine();
		}		
	}
}