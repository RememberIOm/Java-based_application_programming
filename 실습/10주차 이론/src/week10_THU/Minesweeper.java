package week10_THU;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Minesweeper extends JFrame {
	Minesweeper() {
		setTitle("minesweeper");
		setLayout(new GridLayout(0, 20));

		for (int i = 0; i < 300; ++i) {
			add(new JButton(""));
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Minesweeper();
	}
}