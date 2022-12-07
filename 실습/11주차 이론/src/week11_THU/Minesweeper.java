package week11_THU;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Minesweeper extends JFrame {
	Minesweeper() {
		setTitle("minesweeper");
		JMenuBar mb = makeMenu();
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(0, 20));		
		for (int i = 0; i < 300; ++i) {
			JButton b = new JButton("");
			p1.add(b);
			b.addActionListener(e -> {
				b.setBackground(Color.RED);
			});
		}
		
		setJMenuBar(mb);
		add(p1);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 660);
		setVisible(true);
	}
	
	JMenuBar makeMenu() {
		JMenuItem item;
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("게임");
		JMenu m2 = new JMenu("파일");
		JMenu m3 = new JMenu("도움말");
		
		item = new JMenuItem("시작하기");
		m1.add(item);
		item = new JMenuItem("레벨 선택");
		m1.add(item);
		item = new JMenuItem("종료하기");
		m1.add(item);
		item = new JMenuItem("저장");
		m2.add(item);
		item = new JMenuItem("불러오기");
		m2.add(item);
		item = new JMenuItem("도움말");
		m3.add(item);
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		
		return mb;
	}

	public static void main(String[] args) {
		new Minesweeper();
	}
}