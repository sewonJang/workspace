package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManualMove extends JFrame{
	
	JPanel p;
	JButton bt;
	int x,y;
	
	public ManualMove(){
		p = new JPanel(){
			public void paint(Graphics g){
				g.drawOval(x, y, 50, 50);
			}
		};
		p.setBackground(Color.yellow);
		bt= new JButton("움직이기");
		add(bt,BorderLayout.NORTH);
		add(p);
		setSize(600,500);
		setVisible(true);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPoint();
			}
		});
	}
	
	public void setPoint(){
		x++;
		y++;
		repaint();
	}

	public static void main(String[] args) {
		new ManualMove();
	}

}
