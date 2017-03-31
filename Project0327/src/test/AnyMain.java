
package test;

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
		int x,x1,x2,y,z;
		MyMove myMove;
		
		public AnyMain(){
			myMove = new MyMove(this);
			bt = new JButton("¿Å±â±â");
			add(bt,BorderLayout.NORTH);
			
			can= new Canvas(){
				@Override
				public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
				g.drawRect(x1, y+52, 50, 50);
				g.drawOval(x2, y+104, 50, 50);
				}
			};
			
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					myMove.start();
				}
			});
			
			can.setBackground(Color.yellow);
			add(can);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			setSize(700,500);
		}
		public void move(int num){
			x+=num;
			x1+=(num+5);
			x2+=(num+10);
			can.repaint();
		}
		
	public static void main(String[] args) {
	new AnyMain();
	}

}
