package week12_FRI;

import java.io.IOException;

public class Week12_assignment {

	public static void main(String[] args) throws IOException {
		int b, len = 0;
		int ba[] = new int[100];
		
		System.out.println("--- �Է½�Ʈ�� ---");
		while ((b = System.in.read()) != 13) { // ����(\n)�Է� ������ �ѱ��ھ� read �Ѵ�.
			System.out.printf("���� : %c, ������ : (%d)\n", (char) b, b); // int�� read �� ���� char�� int�� ����Ѵ�.
			ba[len++] = b; // len(�ʱⰪ 0)�� ���� b�� �ְ�, len�� ������Ų��.
		}
		
		System.out.println("\n\n--- ��� ��Ʈ�� ---");
		for (int i = 0; i < len; i++) // len�� �� ba�� ���̱� ������ ba�� ��� ���� write �� �� �ְ� len��ŭ �ݺ��Ѵ�.
			System.out.write(ba[i]); // ba���� read �� �״�� ���� ����ֱ� ������ ba�� �ѱ��ھ� write �ϸ� �Է��� �� �״�� ���´�.
		
		System.out.flush(); // ��Ʈ���� flush �Ѵ�.
	}

}