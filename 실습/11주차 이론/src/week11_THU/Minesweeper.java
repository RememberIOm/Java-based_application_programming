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
		JMenu m1 = new JMenu("����");
		JMenu m2 = new JMenu("����");
		JMenu m3 = new JMenu("����");
		
		item = new JMenuItem("�����ϱ�");
		m1.add(item);
		item = new JMenuItem("���� ����");
		m1.add(item);
		item = new JMenuItem("�����ϱ�");
		m1.add(item);
		item = new JMenuItem("����");
		m2.add(item);
		item = new JMenuItem("�ҷ�����");
		m2.add(item);
		item = new JMenuItem("����");
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