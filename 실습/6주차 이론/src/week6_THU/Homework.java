package week6_THU;

import java.util.ArrayList;
import javax.swing.JOptionPane;

interface Grade {
	void setScore();
	void printScore();
}

class MiddeGrade implements Grade {
	char math, english, science;

	@Override
	public void setScore() {
		math = JOptionPane.showInputDialog(null, "���� ����� �Է��ϼ���.", "���б�", JOptionPane.INFORMATION_MESSAGE).charAt(0);
		english = JOptionPane.showInputDialog(null, "���� ����� �Է��ϼ���.", "���б�", JOptionPane.INFORMATION_MESSAGE).charAt(0);
		science = JOptionPane.showInputDialog(null, "���� ����� �Է��ϼ���.", "���б�", JOptionPane.INFORMATION_MESSAGE).charAt(0);
	}

	@Override
	public void printScore() {
		ArrayList<String> gradeList = new ArrayList<String>();
		
		gradeList.add("����=" + math);
		gradeList.add("����=" + english);
		gradeList.add("����=" + science);
		
		System.out.println(MiddeGrade.class.getSimpleName() + " " + gradeList);
	}
}

class HighGrade implements Grade {
	int math1, math2, english, physics;

	@Override
	public void setScore() {
		math1 = Integer.parseInt(JOptionPane.showInputDialog(null,"����1 ������ �Է��ϼ���.","����б�", JOptionPane.INFORMATION_MESSAGE));
		math2 = Integer.parseInt(JOptionPane.showInputDialog(null,"����2 ������ �Է��ϼ���.","����б�", JOptionPane.INFORMATION_MESSAGE));
		english = Integer.parseInt(JOptionPane.showInputDialog(null,"���� ������ �Է��ϼ���.","����б�", JOptionPane.INFORMATION_MESSAGE));
		physics = Integer.parseInt(JOptionPane.showInputDialog(null,"���� ������ �Է��ϼ���.","����б�", JOptionPane.INFORMATION_MESSAGE));
	}

	@Override
	public void printScore() {
	ArrayList<String> gradeList = new ArrayList<String>();
	
	gradeList.add("����=" + math1);
	gradeList.add("����=" + math2);
	gradeList.add("����=" + english);
	gradeList.add("����=" + physics);
	
	System.out.println(HighGrade.class.getSimpleName() + " " + gradeList);
	}
}

class UnivGrade implements Grade {
	String java, english, oop, ds;

	@Override
	public void setScore() {
		java = JOptionPane.showInputDialog(null,"�ڹ� ������ �Է��ϼ���.","��������", JOptionPane.INFORMATION_MESSAGE);
		english = JOptionPane.showInputDialog(null,"���п��� ������ �Է��ϼ���.","��������", JOptionPane.INFORMATION_MESSAGE);
		oop = JOptionPane.showInputDialog(null,"��ü���� ������ �Է��ϼ���.","��������", JOptionPane.INFORMATION_MESSAGE);
		ds = JOptionPane.showInputDialog(null,"�ڷᱸ�� ������ �Է��ϼ���.","��������", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void printScore() {
		ArrayList<String> gradeList = new ArrayList<String>();
		
		gradeList.add("�ڹ�=" + java);
		gradeList.add("���п���=" + english);
		gradeList.add("��ü����=" + oop);
		gradeList.add("�ڷᱸ��=" + ds);
		
		System.out.println(UnivGrade.class.getSimpleName() + " " + gradeList);
	}
}

public class Homework {
	public static void main(String[] args) {
		Grade grade[] = { new MiddeGrade(), new HighGrade(), new UnivGrade() };
		for (Grade g : grade) {
			g.setScore();
		}
		for (Grade g : grade) {
			g.printScore();
		}
	}
}