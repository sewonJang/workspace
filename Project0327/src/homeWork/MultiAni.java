/*
 * 	 ���� �ٸ� �׷���, �ӵ�, ��Ÿ ���� ����
 * ��ü�� �����̰� ����!
 * 
 * */
package homeWork;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiAni extends JFrame {
	JButton bt;
	Canvas can;
	CircleThread ct;


	public MultiAni() {
		bt = new JButton("���� �����̱�");
		can = new Canvas() {
			public void paint(Graphics g) {
			
			}
		};
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = can.getGraphics();
				
				CircleThread ct = new CircleThread(0, 0, 50, 50, 100, g);
				//ShapeThread st = ct;
				//st.start(); �̰͵� ���� 
				RectThread rt = new RectThread(0, 60, 50, 50, 50, g);
			}
		});
		can.setBackground(Color.YELLOW);
		add(bt, BorderLayout.NORTH);
		add(can);

		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new MultiAni();
	}

}
