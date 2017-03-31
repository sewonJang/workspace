package progressbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarTest extends JFrame{
	JButton bt;
	JProgressBar[] bar= new JProgressBar[3];
	BarThread1 mb[] = new BarThread1[3];
	int[] interval={100,500,1000};

	int percent;
	public ProgressBarTest() {
		bt = new JButton("¿€µø");
		
		for(int i=0; i<bar.length;i++){
			bar[i]= new JProgressBar();
			mb[i]=new BarThread1(bar[i],interval[i] );
			add(bar[i]);
		}
		add(bt);
		
		setLayout(new FlowLayout());
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ProgressBarTest();
	}

}
