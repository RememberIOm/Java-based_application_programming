package week10_FRI;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

class OddEvenCounter extends JFrame {
	CardLayout layout;
	
	public void count(int iter) {		
		for (int i = 1; i < iter; ++i) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
			layout.next(this.getContentPane());
		}
	}
	OddEvenCounter() {
		setTitle("Ȧ¦ ī��Ʈ");
		layout = new CardLayout();
		setLayout(layout);
		
		add(new JButton("Ȧ"));	
		add(new JButton("¦"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		setVisible(true);
	}
}

public class Week10_givenCode {
	public static void main(String[] args) {
		new OddEvenCounter().count(5);
	}
}
