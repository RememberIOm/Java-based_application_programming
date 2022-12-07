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
		math = JOptionPane.showInputDialog(null, "수학 등급을 입력하세요.", "중학교", JOptionPane.INFORMATION_MESSAGE).charAt(0);
		english = JOptionPane.showInputDialog(null, "영어 등급을 입력하세요.", "중학교", JOptionPane.INFORMATION_MESSAGE).charAt(0);
		science = JOptionPane.showInputDialog(null, "과학 등급을 입력하세요.", "중학교", JOptionPane.INFORMATION_MESSAGE).charAt(0);
	}

	@Override
	public void printScore() {
		ArrayList<String> gradeList = new ArrayList<String>();
		
		gradeList.add("수학=" + math);
		gradeList.add("영어=" + english);
		gradeList.add("과학=" + science);
		
		System.out.println(MiddeGrade.class.getSimpleName() + " " + gradeList);
	}
}

class HighGrade implements Grade {
	int math1, math2, english, physics;

	@Override
	public void setScore() {
		math1 = Integer.parseInt(JOptionPane.showInputDialog(null,"수학1 점수를 입력하세요.","고등학교", JOptionPane.INFORMATION_MESSAGE));
		math2 = Integer.parseInt(JOptionPane.showInputDialog(null,"수학2 점수를 입력하세요.","고등학교", JOptionPane.INFORMATION_MESSAGE));
		english = Integer.parseInt(JOptionPane.showInputDialog(null,"영어 점수를 입력하세요.","고등학교", JOptionPane.INFORMATION_MESSAGE));
		physics = Integer.parseInt(JOptionPane.showInputDialog(null,"물리 점수를 입력하세요.","고등학교", JOptionPane.INFORMATION_MESSAGE));
	}

	@Override
	public void printScore() {
	ArrayList<String> gradeList = new ArrayList<String>();
	
	gradeList.add("수학=" + math1);
	gradeList.add("수학=" + math2);
	gradeList.add("영어=" + english);
	gradeList.add("물리=" + physics);
	
	System.out.println(HighGrade.class.getSimpleName() + " " + gradeList);
	}
}

class UnivGrade implements Grade {
	String java, english, oop, ds;

	@Override
	public void setScore() {
		java = JOptionPane.showInputDialog(null,"자바 학점을 입력하세요.","대학점수", JOptionPane.INFORMATION_MESSAGE);
		english = JOptionPane.showInputDialog(null,"대학영어 학점을 입력하세요.","대학점수", JOptionPane.INFORMATION_MESSAGE);
		oop = JOptionPane.showInputDialog(null,"객체지향 학점을 입력하세요.","대학점수", JOptionPane.INFORMATION_MESSAGE);
		ds = JOptionPane.showInputDialog(null,"자료구조 학점을 입력하세요.","대학점수", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void printScore() {
		ArrayList<String> gradeList = new ArrayList<String>();
		
		gradeList.add("자바=" + java);
		gradeList.add("대학영어=" + english);
		gradeList.add("객체지향=" + oop);
		gradeList.add("자료구조=" + ds);
		
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