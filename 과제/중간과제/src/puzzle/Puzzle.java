package puzzle;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Puzzle extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int idx=15;
	Puzzle(){
		setLayout(new GridLayout(4,4));
		JButton j[] = new JButton[16];
		//참고하여 수정 1
		List<Integer> randList = new ArrayList<>();
		int entropy = 1; //"무질서도"가 홀수이면 퍼즐의 해가 없음
		while (entropy % 2 != 0) {
			randList.clear();
			Set<Integer> randSet = new LinkedHashSet<>(); //Set으로 중복 제거
			while (randSet.size() != 15) {
				randSet.add((int)(Math.random() * 15) + 1);
			}
			Iterator<Integer> iter = randSet.iterator();
		
			//해가 존재하는지 검사
			while (iter.hasNext()) { //Set을 List로 복사
				randList.add(iter.next());
			}
		
			entropy = 0;
			for (int first = 0; first < 15; ++first) { //순서가 거꾸로인 순서쌍의 갯수 = 무질서도
				for (int last = first + 1; last < 15; ++last) {
					if (randList.get(first) > randList.get(last)) {
						++entropy;
					}
				}
			}
		}
		
		//수정됨
		for (int i=0;i<16;i++) {
			if(i==15)
				j[i] = new JButton("");
			else
				j[i] = new JButton(""+(randList.get(i)));
			
			
			
			j[i].addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					int key = e.getKeyCode();
					if(key == 37) {//left
						if (idx % 4 == 0) {
							//nothing
						}
						else {
							String target = j[idx-1].getText();
							j[idx].setText(target);
							j[idx-1].setText("");
							idx=idx-1;
						}						
					}
					else if(key == 38) {//up
						if (idx <= 3) {
							//nothing
						}
						else {
							String target = j[idx-4].getText();
							j[idx].setText(target);
							j[idx-4].setText("");
							idx=idx-4;
						}
					}
					else if(key==39) {//right
						if (idx % 4 == 3) {
							//nothing
						}
						else {
							String target = j[idx+1].getText();
							j[idx].setText(target);
							j[idx+1].setText("");
							idx=idx+1;
						}
					}
					else if(key==40) {//down
						if (idx >= 12) {
							//nothing
						}
						else {
							String target = j[idx+4].getText();
							j[idx].setText(target);
							j[idx+4].setText("");
							idx=idx+4;
						}
					}
					else if(key==27){
						System.exit(0);
					}
					//종료조건 확인 코드
					boolean isExit = true; 
					for (int i = 0; i < 16; ++i) {
						String currentNum = j[i].getText();
						String check = Integer.toString(i + 1);
						if (i == 15) {
							check = "";
						}						
						
						if (currentNum.equals(check)) {
							//nothing
						}
						else { //칸의 원래 위치와 다르면 false로 고정
							isExit = false;
						}
					}
					if (isExit == true) { //true이면 exit
						System.exit(0);
					}
					//수정됨
				}
			});
			
			
			add(j[i]);
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400,420);
		setVisible(true);
		
		
	}
	public static void main(String[] args) throws IOException {
		
		Puzzle p =new Puzzle();
		int i = (int) ((Math.random())*25);
		System.out.println(i);
		
		// 랜덤하게 생성 
		// 게임 종료 조건 구현 
		// 좌우 이동에 관한 처리 +  위아래 이동에 관한 처리
		
	}	
}