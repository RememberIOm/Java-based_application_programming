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
		//�����Ͽ� ���� 1
		List<Integer> randList = new ArrayList<>();
		int entropy = 1; //"��������"�� Ȧ���̸� ������ �ذ� ����
		while (entropy % 2 != 0) {
			randList.clear();
			Set<Integer> randSet = new LinkedHashSet<>(); //Set���� �ߺ� ����
			while (randSet.size() != 15) {
				randSet.add((int)(Math.random() * 15) + 1);
			}
			Iterator<Integer> iter = randSet.iterator();
		
			//�ذ� �����ϴ��� �˻�
			while (iter.hasNext()) { //Set�� List�� ����
				randList.add(iter.next());
			}
		
			entropy = 0;
			for (int first = 0; first < 15; ++first) { //������ �Ųٷ��� �������� ���� = ��������
				for (int last = first + 1; last < 15; ++last) {
					if (randList.get(first) > randList.get(last)) {
						++entropy;
					}
				}
			}
		}
		
		//������
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
					//�������� Ȯ�� �ڵ�
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
						else { //ĭ�� ���� ��ġ�� �ٸ��� false�� ����
							isExit = false;
						}
					}
					if (isExit == true) { //true�̸� exit
						System.exit(0);
					}
					//������
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
		
		// �����ϰ� ���� 
		// ���� ���� ���� ���� 
		// �¿� �̵��� ���� ó�� +  ���Ʒ� �̵��� ���� ó��
		
	}	
}