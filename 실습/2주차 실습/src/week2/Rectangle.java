package week2;

import java.util.Scanner;

public class Rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int width, height;
		
		width = sc.nextInt();
		height = sc.nextInt();
		
		System.out.println("직사각형의 넓이는 " + width * height + "입니다.");

	}

}