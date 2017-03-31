
package Thread2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnyMain extends JFrame{
		JButton bt;
		Canvas can;
		int x,y;
		Thread thread;//내부익명 스타일로 개발
		
		public AnyMain(){
			thread = new Thread(){
				@Override
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
				
			};
			bt = new JButton("옮기기");
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
	public static void main(String[] args) {
	new AnyMain();
	}

}
