import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		
		String name = new String();
		int grade = 0;
		
		System.out.print("�л�" + (map.size() + 1) + "�� �̸��� �Է��ϼ��� : ");
		name = sc.next();
		while (!name.equals("exit")) {
			System.out.print("����" + (map.size() + 1) + "�� �Է��ϼ��� : ");
			grade = sc.nextInt();
			
			map.put(name, grade);
			
			System.out.print("�л�" + (map.size() + 1) + "�� �̸��� �Է��ϼ��� : ");
			name = sc.next();
		}
		
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		int cnt = 1;
		while (iter.hasNext()) {
			String key = (String)iter.next();
			Integer value = map.get(key);
			String finalGrade = new String();
			
			if (value >= 90) {
				finalGrade = "A";
			}
			else if (value >= 80) {
				finalGrade = "B";
			}
			else {
				finalGrade = "C";
			}
			
			System.out.println(cnt++ + "�� �л� " + key + "�� ����� " + finalGrade + "�Դϴ�.");
		}
	}
}