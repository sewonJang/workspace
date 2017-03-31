
package thread;

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
		MyMoveThread mmt;
		AnyMain anyMain;
		int x,y;
		
		public AnyMain(){
			anyMain=this;
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
					mmt = new MyMoveThread(anyMain);
					//mmt = new MyMoveThread(AnyMain.this); 이것도 가능 
					mmt.start();
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
