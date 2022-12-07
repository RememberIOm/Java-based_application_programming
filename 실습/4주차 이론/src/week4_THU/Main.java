package week4_THU;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String userInput = sc.nextLine();
		
		while (!userInput.equals("exit")) {
			if (userInput.equals("안녕?")) {
				System.out.println("안녕");
			} else if (userInput.equals("이름이뭐니?")) {
				System.out.println("이준용");
			} else if (userInput.equals("오늘날씨는어때?")) {
				System.out.println("인터넷으로확인해봐");
			} else if (userInput.equals("자바기반응용프로그래밍 수업 어떠니?")) {
				System.out.println("재미있어");
			} else if (userInput.equals("지금기분은어떠니?")) {
				System.out.println("나쁘지않아");
			} else {
				System.out.println("난 그건 잘 모르겠어.");
			}
			
			userInput = sc.nextLine();
		}		
	}
}