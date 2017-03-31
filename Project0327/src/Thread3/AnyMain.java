
package Thread3;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//�����ڰ� �����带 ����Ͽ� ���� �� �� ������
//�̹� �ٸ� Ŭ������ �ڽ��� ���, ����� �Ұ�
//�̷��� ����� �� �ִ� ��ü�� �ٷ� 
//Runnalble �������̽��̴�. 
public class AnyMain extends JFrame implements Runnable{
		JButton bt;
		Canvas can;
		int x,y;
		Thread thread;//�����͸� ��Ÿ�Ϸ� ����
		
		public AnyMain(){
			//Runnable�� ��ü�� �μ��� �ѱ��
			//�׷���, run �޼����� ȣ���� Runnable
			//�� �������� ��ü�� run�� ȣ���Ѵ�.
			
			thread = new Thread(this);
			bt = new JButton("�ű��");
			add(bt,BorderLayout.NORTH);
			
			can= new Canvas(){
				@Override
				public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
				}
			};
			
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					thread.start();
				}
			});
			
			can.setBackground(Color.yellow);
			add(can);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			setSize(700,500);
			
		}
		public void move(){
				
				x+=5;
				y+=5;
				can.repaint();
		}
		public void run() {
			while(true){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				move();
			}
		}
	public static void main(String[] args) {
	new AnyMain();
	}

	

}
