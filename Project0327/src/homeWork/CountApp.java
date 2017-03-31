package homeWork;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountApp extends JFrame {
	JLabel lb_left;
	JLabel lb_right;
	CountThread ct;
	CountThread1 ct1;
	int num1;
	int num2;
	public CountApp(){
		lb_left= new JLabel("0");
		lb_right=  new JLabel("0");
		
		ct = new CountThread(this);
		ct.start();
		
		ct1 = new CountThread1(this);
		ct1.start();
		
		setLayout(new FlowLayout());
		add(lb_left);
		add(lb_right);
		
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CountApp();
	}

}
