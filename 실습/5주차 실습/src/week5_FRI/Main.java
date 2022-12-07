package week5_FRI;

class Square {
	private String color = "하얀";
	private int Area = 1;
	
	Square(String colorInput, int areaInput) {
		color = colorInput;
		Area = areaInput;
	}
	Square(String colorInput) {
		color = colorInput;
	}
	Square(int areaInput) {
		Area = areaInput;
	}
	Square() {
		
	}
	
	public void printSquare() {
		System.out.println("이 정사각형은 넓이가 " + Area + "인 " + color + "색 입니다.");
	}
}

public class Main {
	public static void main(String[] args) {
		Square s1 = new Square("빨강", 5);
		Square s2 = new Square("주황");
		Square s3 = new Square(3);
		Square s4 = new Square();
		s1.printSquare();
		s2.printSquare();
		s3.printSquare();
		s4.printSquare();
	}
}