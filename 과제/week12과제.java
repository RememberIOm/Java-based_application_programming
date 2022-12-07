import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Minesweeper extends JFrame {
	ArrayList<JButton> buttons = new ArrayList<>();
	String saveFilePath = "save.txt";
	int buttonsNum = 300;
	
	Minesweeper() {
		setTitle("minesweeper");
		JMenuBar mb = makeMenu();		
		JPanel p1 = new JPanel();		
		p1.setLayout(new GridLayout(0, 20));
		
		for (int i = 0; i < buttonsNum; ++i) {
			JButton b = new JButton();
			b.addActionListener(redEvent -> {
				b.setBackground(Color.RED);
				b.setOpaque(true);
			});
			
			buttons.add(b);
		}
		
		for (JButton b : buttons) {
			p1.add(b);
		}
		
		setJMenuBar(mb);
		add(p1);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1150, 950);
		setVisible(true);
	}
	
	JMenuBar makeMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("게임");
		JMenu m2 = new JMenu("파일");
		JMenu m3 = new JMenu("도움말");
		
		//m1
		m1.add(makeStart());
		m1.add(makeSetLevel());
		m1.add(makeQuit());
		
		//m2
		m2.add(makeSave());
		m2.add(makeLoad());
		
		//m3
		m3.add(makeHelp());
		
		//menuBar add
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		
		return mb;
	}
	
	JMenuItem makeStart() {
		JMenuItem item;
		item = new JMenuItem("시작하기");
		item.addActionListener(startEvent -> {
			ArrayList<Integer> randNum = new ArrayList<>();
			for (int i = 1; i <= buttonsNum; ++i) {
				randNum.add(i);
			}
			
			Collections.shuffle(randNum);
			
			for (int i = 0; i < buttonsNum; ++i) {
				buttons.get(i).setText(randNum.get(i).toString());
			}
		});
		
		return item;
	}
	
	JMenuItem makeQuit() {
		JMenuItem item;
		item = new JMenuItem("종료하기");
		
		return item;
	}
	
	JMenuItem makeSetLevel() {
		JMenuItem item;
		item = new JMenuItem("레벨 선택");
		
		return item;
	}

	JMenuItem makeSave() {
		JMenuItem item;
		item = new JMenuItem("저장");
		item.addActionListener(saveEvent -> {
			String numsToString = "";
			
			for (JButton b : buttons) {
				numsToString += b.getText() + " ";
			}
			
			try {
				FileWriter fw = new FileWriter(saveFilePath);
				
				for (int i = 0; i < numsToString.length(); ++i) {
					char c = numsToString.charAt(i);
					fw.write(c);
				}
				
				fw.flush();
			}
			catch (IOException e) {
			}
		});
		
		return item;
	}
	
	JMenuItem makeLoad() {
		JMenuItem item;
		item = new JMenuItem("불러오기");
		item.addActionListener(loadEvent -> {
			String numsToString = "";
			
			try {
				FileReader fr = new FileReader(saveFilePath);
				int c = 0;
				
				while ((c = fr.read())!= -1) {
					numsToString += (char)c;
				}
				
				String[] nums = numsToString.split(" ");
				for (int i = 0; i < buttonsNum; ++i) {
					buttons.get(i).setText(nums[i]);
				}
			}
			catch (IOException e) {
			}
		});
		
		return item;
	}
	
	JMenuItem makeHelp() {
		JMenuItem item;
		item = new JMenuItem("도움말");
		
		return item;
	}

	public static void main(String[] args) {
		new Minesweeper();
	}
}