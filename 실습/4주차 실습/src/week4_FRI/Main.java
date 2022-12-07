package week4_FRI;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("*을 이용하여 출력할 모양을 입력하세요.");
		System.out.println("1: 왼쪽으로 치우친 아래쪽이 큰 삼각형");
		System.out.println("2: 오른쪽으로 치우친 아래쪽이 큰 삼각형");
		System.out.println("3: 우상단에서 좌하단 부분이 비어있는 정사각형");
		System.out.println("이외의 입력인 경우 종료.");
		int type = in.nextInt(), line;
		
		while(type>=1 && type<=3){
			System.out.print("출력할 줄의 개수를 입력하세요 : ");	line=in.nextInt();
			printStar(type,line);
			
			System.out.println("*을 이용하여 출력할 모양을 입력하세요.");
			System.out.println("1: 왼쪽으로 치우친 아래쪽이 큰 삼각형");
			System.out.println("2: 오른쪽으로 치우친 아래쪽이 큰 삼각형");
			System.out.println("3: 우상단에서 좌하단 부분이 비어있는 정사각형");
			System.out.println("이외의 입력인 경우 종료.");
			type = in.nextInt();
		}
		System.out.println("프로그램이 종료되었습니다.");
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