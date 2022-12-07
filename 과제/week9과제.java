package puzzle;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

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
		for (int i=0;i<16;i++) {
			if(i==15)
				j[i] = new JButton("");
			else
				j[i] = new JButton(""+(i+1));
			
			
			
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
					try {
						if(key == 37) {//left
							String target = j[idx-1].getText();
							j[idx].setText(target);
							j[idx-1].setText("");
							idx=idx-1;	
						}
						else if(key == 38) {//down
							String target = j[idx-4].getText();
							j[idx].setText(target);
							j[idx-4].setText("");
							idx=idx-4;						
						}
						else if(key==39) {//right
							String target = j[idx+1].getText();
							j[idx].setText(target);
							j[idx+1].setText("");
							idx=idx+1;
						}
						else if(key==40) {//up
							String target = j[idx+4].getText();
							j[idx].setText(target);
							j[idx+4].setText("");
							idx=idx+4;
						}
						else if(key==27){
							System.exit(0);
						}
					//종료조건 확인 코드
					}
					catch(Exception excp) {
						
					}

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