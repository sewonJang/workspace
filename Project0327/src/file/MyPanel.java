/*
	패널이 라벨과 버튼을 가지고 있다.
	Jpanel has aLabel & JButton
*/
package file;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	JButton bt;
	JLabel la;
	public MyPanel(String title, Icon icon){
		bt = new JButton(icon);
		la = new JLabel(title);
		
		this.setLayout(new BorderLayout());
		add(la,BorderLayout.NORTH);
		add(bt);
	}
}
