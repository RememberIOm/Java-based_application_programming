package week7_FRI;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		List<List<Integer>> pascal = new ArrayList<>();
		for (int col = 0; col < N; ++col) {
			pascal.add(new ArrayList<>());
			for (int row = 0; row < N; ++row) {
				pascal.get(col).add(0);
			}
		}

		for (int col = 0; col < N; ++col) {
			for (int row = 0; row < N; ++row) {
				if ((col != 0 && row == 0) || col == 0) {
					pascal.get(col).set(row, 1);
				} else {
					pascal.get(col).set(row, pascal.get(col - 1).get(row) + pascal.get(col).get(row - 1));
				}
			}
		}

		for (int i = 0; i < N; ++i) {
			System.out.println(pascal.get(i).get(N - i - 1));
		}
	}
}