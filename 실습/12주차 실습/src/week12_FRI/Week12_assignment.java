package week12_FRI;

import java.io.IOException;

public class Week12_assignment {

	public static void main(String[] args) throws IOException {
		int b, len = 0;
		int ba[] = new int[100];
		
		System.out.println("--- 입력스트림 ---");
		while ((b = System.in.read()) != 13) { // 엔터(\n)입력 전까지 한글자씩 read 한다.
			System.out.printf("문자 : %c, 십진수 : (%d)\n", (char) b, b); // int로 read 된 것을 char과 int로 출력한다.
			ba[len++] = b; // len(초기값 0)에 값을 b로 넣고, len을 증가시킨다.
		}
		
		System.out.println("\n\n--- 출력 스트림 ---");
		for (int i = 0; i < len; i++) // len이 곧 ba의 길이기 때문에 ba의 모든 값을 write 할 수 있게 len만큼 반복한다.
			System.out.write(ba[i]); // ba에는 read 한 그대로 값이 들어있기 때문에 ba를 한글자씩 write 하면 입력한 값 그대로 나온다.
		
		System.out.flush(); // 스트림을 flush 한다.
	}

}