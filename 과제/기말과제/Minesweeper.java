import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Minesweeper extends JFrame {
	ArrayList<MyButton> buttons = new ArrayList<>();
	ArrayList<Integer> mines = new ArrayList<>();
	JPanel p1 = new JPanel();
	JLabel minesView = new JLabel(), timerView = new JLabel();
	String saveFilePath = "save.txt";
	int BUTTON_ROW = 20, BUTTON_COL = 10;
	int BUTTONS_NUM = BUTTON_ROW * BUTTON_COL;
	int WINDOW_SIZE_ROW = BUTTON_ROW * 45, WINDOW_SIZE_COL = BUTTON_COL * 45 + 50;
	Integer MINES_NUM = 40, REMAIN_MINES_NUM = 0;
	long timerStart = 0, timerCurrent = 0, timerSave = 0, timerLoad = 0;
	boolean isInGame = false, isGameOver = false;

	Minesweeper() {
		setTitle("Minesweeper");
		setJMenuBar(makeMenu());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		JPanel p0 = new JPanel();
		p0.setLayout(new BorderLayout());

		p0.add("West", minesView);
		p0.add("East", timerView);

		add("North", p0);

		setMinesweeperLayout(1);

		String[] selectLevel = { "초급", "중급", "고급" };
		int selected = JOptionPane.showOptionDialog(p1, "난이도 선택", "Minesweeper", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, selectLevel, selectLevel[1]);
		if (selected == 0) {
			setEasy();
			setStart();
		} else if (selected == 1) {
			setNormal();
			setStart();
		} else {
			setHard();
			setStart();
		}
	}

	class Timer implements Runnable {
		public void run() {
			timerStart = System.currentTimeMillis();

			while (isInGame) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				timerCurrent = System.currentTimeMillis();
				long timerCalculated = timerLoad + timerCurrent - timerStart;

				timerView.setText("경과 시간: " + (timerCalculated) / 60000 + "분 " + (timerCalculated) / 1000 % 60 + "."
						+ (timerCalculated) / 100 % 10 + "초");

				timerSave = timerCalculated;
			}
		}
	}

	void setMinesweeperLayout(int buttonsClear) {
		setFinalValue();
		minesView.setText("남은 지뢰: " + REMAIN_MINES_NUM);
		timerView.setText("경과 시간: 0분 0.0초");

		p1.removeAll();
		remove(p1);

		p1.setLayout(new GridLayout(BUTTON_COL, BUTTON_ROW));

		if (buttonsClear == 1) {
			buttons.clear();
			for (int col = 0; col < BUTTON_COL; ++col) {
				for (int row = 0; row < BUTTON_ROW; ++row) {
					MyButton b = new MyButton(row, col);

					buttons.add(b);
				}
			}
		}

		for (MyButton b : buttons) {
			p1.add(b);
		}

		add("Center", p1);

		setSize(WINDOW_SIZE_ROW, WINDOW_SIZE_COL);
		revalidate();
		repaint();
	}

	JMenuBar makeMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("게임");
		JMenu m2 = new JMenu("파일");
		JMenu m3 = new JMenu("도움말");

		// m1
		m1.add(makeStart());
		m1.add(makeSetLevel());
		m1.add(makeQuit());

		// m2
		m2.add(makeSave());
		m2.add(makeLoad());

		// m3
		m3.add(makeHelp());

		// menuBar add
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);

		return mb;
	}

	JMenuItem makeStart() {
		JMenuItem item;
		item = new JMenuItem("시작하기");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setStart();
			}
		});

		return item;
	}

	void setStart() {
		timerLoad = 0;
		isInGame = false;
		isGameOver = false;
		mines.clear();

		ArrayList<Integer> randNum = new ArrayList<>();
		for (int i = 1; i <= BUTTONS_NUM; ++i) {
			randNum.add(i);
		}

		Collections.shuffle(randNum);

		for (int i = 0; i < MINES_NUM; ++i) {
			mines.add(randNum.get(i));
		}

		setMinesweeperLayout(1);
	}

	JMenuItem makeQuit() {
		JMenuItem item;
		item = new JMenuItem("종료하기");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		return item;
	}

	JMenu makeSetLevel() {
		JMenu item;
		item = new JMenu("레벨 선택");

		JMenuItem subItem;
		subItem = new JMenuItem("초급");
		subItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEasy();
				setStart();
			}
		});
		item.add(subItem);

		subItem = new JMenuItem("중급");
		subItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNormal();
				setStart();
			}
		});
		item.add(subItem);

		subItem = new JMenuItem("고급");
		subItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setHard();
				setStart();
			}
		});
		item.add(subItem);

		return item;
	}

	void setEasy() {
		BUTTON_ROW = 10;
		BUTTON_COL = 10;
		MINES_NUM = 10;
		setFinalValue();

		mines.clear();
		setMinesweeperLayout(1);
	}

	void setNormal() {
		BUTTON_ROW = 20;
		BUTTON_COL = 10;
		MINES_NUM = 40;
		setFinalValue();

		mines.clear();
		setMinesweeperLayout(1);
	}

	void setHard() {
		BUTTON_ROW = 30;
		BUTTON_COL = 20;
		MINES_NUM = 99;
		setFinalValue();

		mines.clear();
		setMinesweeperLayout(1);
	}

	void setFinalValue() {
		BUTTONS_NUM = BUTTON_ROW * BUTTON_COL;
		WINDOW_SIZE_ROW = BUTTON_ROW * 45;
		WINDOW_SIZE_COL = BUTTON_COL * 45 + 50;
		REMAIN_MINES_NUM = MINES_NUM;
	}

	JMenuItem makeSave() {
		JMenuItem item;
		item = new JMenuItem("저장");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String saveFileStringSave = "";
				
				for (MyButton b : buttons) {
					if (b.isOpen) {
						saveFileStringSave += "1";
					}
					else {
						saveFileStringSave += "0";
					}
					
					if (b.isMine) {
						saveFileStringSave += "1";
					}
					else {
						saveFileStringSave += "0";
					}
					
					if (b.isFlag) {
						saveFileStringSave += "1";
					}
					else {
						saveFileStringSave += "0";
					}
					
					saveFileStringSave += "\n";
				}
				
				saveFileStringSave += timerSave;
				saveFileStringSave += "\n";
				
				if (isGameOver) {
					saveFileStringSave += "1";
				}
				else {
					saveFileStringSave += "0";
				}
				
				saveFileStringSave += "\n";
				saveFileStringSave += REMAIN_MINES_NUM.toString();
				
				try {
					FileWriter fw = new FileWriter(saveFilePath);
					
					for (int i = 0; i < saveFileStringSave.length(); ++i) {
						char c = saveFileStringSave.charAt(i);
						fw.write(c);
					}
					
					fw.flush();
				}
				catch (IOException exp) {
				}
			}
		});
		
		return item;
	}

	JMenuItem makeLoad() {
		JMenuItem item;
		item = new JMenuItem("불러오기");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String saveFileStringLoad = "";
				List<String> stateButtons = new ArrayList<>();

				try {
					FileReader fr = new FileReader(saveFilePath);
					int c = 0;

					while ((c = fr.read()) != -1) {
						saveFileStringLoad += (char) c;
					}

					String[] nums = saveFileStringLoad.split("\n");

					stateButtons = Arrays.asList(nums);
				} catch (IOException exp) {
				}

				if (stateButtons.size() == 103) {
					setEasy();
				} else if (stateButtons.size() == 203) {
					setNormal();
				} else {
					setHard();
				}

				buttons.clear();

				for (int i = 0; i < stateButtons.size() - 3; ++i) {
					MyButton b = new MyButton(i % BUTTON_ROW, i / BUTTON_ROW);

					if (stateButtons.get(i).charAt(0) == '1') {
						b.isOpen = true;
					}

					if (stateButtons.get(i).charAt(1) == '1') {
						b.isMine = true;
					}

					if (stateButtons.get(i).charAt(2) == '1') {
						b.isFlag = true;
					}

					buttons.add(b);
				}

				setMinesweeperLayout(0);

				timerLoad = Integer.parseInt(stateButtons.get(stateButtons.size() - 3));
				isInGame = false;

				for (MyButton b : buttons) {
					if (b.isOpen) {
						b.isOpen = false;
						b.open();
					}
					else if (b.isFlag) {
						b.setBackground(Color.blue);
					}
				}

				if (stateButtons.get(stateButtons.size() - 2).equals("1")) {
					isGameOver = true;
					isInGame = false;
				}
				else {
					isGameOver = false;
				}
				
				REMAIN_MINES_NUM = Integer.parseInt(stateButtons.get(stateButtons.size() - 1));
				minesView.setText("남은 지뢰: " + REMAIN_MINES_NUM);
			}
		});

		return item;
	}

	JMenuItem makeHelp() {
		JMenuItem item;
		item = new JMenuItem("도움말");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(p1, "지뢰찾기. 12191650 이준용", "도움말", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		return item;
	}

	class MyButton extends JButton {
		boolean isMine = false, isFlag = false, isOpen = false;
		int currentRow = -1, currentCol = -1;

		MyButton(int row, int col) {
			currentRow = row;
			currentCol = col;

			if (mines.contains(currentRow + currentCol * BUTTON_ROW)) {
				isMine = true;
			}

			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (SwingUtilities.isLeftMouseButton(e)) {
						if (!isGameOver) {
							if (isMine && !isFlag) {
								for (MyButton b : buttons) {
									if (b.isMine) {
										b.open();
									}
								}

								isInGame = false;
								isGameOver = true;
								JOptionPane.showMessageDialog(p1, "으악", "결과", JOptionPane.INFORMATION_MESSAGE);
							} else {
								open();

								boolean isWin = true;
								for (MyButton b : buttons) {
									if (!b.isMine && !b.isOpen) {
										isWin = false;
									}
								}

								if (isWin == true) {
									isInGame = false;
									isGameOver = true;
									JOptionPane.showMessageDialog(p1, "나이스", "결과", JOptionPane.INFORMATION_MESSAGE);

									for (MyButton b : buttons) {
										if (b.isMine && !b.isFlag) {
											b.isFlag = true;
											b.setBackground(Color.blue);
											minesView.setText("남은 지뢰: " + --REMAIN_MINES_NUM);
										}
									}
								}
							}
						}
					} else if (SwingUtilities.isRightMouseButton(e)) {
						if (!isOpen && !isGameOver) {
							if (!isFlag) {
								isFlag = true;
								setBackground(Color.blue);
								minesView.setText("남은 지뢰: " + --REMAIN_MINES_NUM);
							} else {
								isFlag = false;
								setBackground(null);
								minesView.setText("남은 지뢰: " + ++REMAIN_MINES_NUM);
							}
						}
					}
				}
			});
		}

		void open() {
			if (!isOpen && !isFlag) {
				if (!isInGame) {
					isInGame = true;
					Thread timerThread = new Thread(new Timer());
					timerThread.start();
				}

				isOpen = true;

				if (isMine) {
					setBackground(Color.red);
				} else {
					String nearMinesNumText = viewNearMinesNum().toString();

					if (nearMinesNumText.equals("0")) {
						setBackground(Color.gray);

						for (int col = currentCol - 1; col <= currentCol + 1; ++col) {
							for (int row = currentRow - 1; row <= currentRow + 1; ++row) {
								try {
									if (row >= 0 && row < BUTTON_ROW) {
										buttons.get(row + col * BUTTON_ROW).open();
									}
								} catch (Exception e) {
									continue;
								}
							}
						}
					} else {
						setBackground(Color.white);
						setText(nearMinesNumText);
					}
				}
			}
		}

		Integer viewNearMinesNum() {
			Integer nearMinesNum = 0;

			for (int col = currentCol - 1; col <= currentCol + 1; ++col) {
				for (int row = currentRow - 1; row <= currentRow + 1; ++row) {
					try {
						if (row >= 0 && row < BUTTON_ROW && buttons.get(row + col * BUTTON_ROW).isMine) {
							++nearMinesNum;
						}
					} catch (Exception e) {
						continue;
					}
				}
			}

			return nearMinesNum;
		}
	}

	public static void main(String[] args) {
		new Minesweeper();
	}
}