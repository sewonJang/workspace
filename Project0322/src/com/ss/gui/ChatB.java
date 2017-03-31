package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatB extends JFrame implements KeyListener {
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	//�ʿ��� ��ü, �� ����� ��ü�� �ִٸ� 
	//has a ����� �������� 
	ChatA chatA;// null;
	ChatC chatC;

	public ChatB() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(15);

		this.add(scroll);
		p_south.add(t_input);

		this.add(p_south, BorderLayout.SOUTH);
		this.add(scroll);

		t_input.addKeyListener(this);

		setBounds(400, 100, 300, 400);
		setVisible(true);
	}
	

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			area.append(t_input.getText()+"\n");
			chatA.area.append(t_input.getText() + "\n");
			chatC.area.append(t_input.getText() + "\n");
			t_input.setText("");
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	//�ܺ��� � ��ü��, ������ �����͸� 
	//���Խ����� �� �ִ� setter�� �غ�����!!
	public void setChatA(ChatA chatA){
		this.chatA=chatA;
	}
	public void setChatC(ChatC chatC){
		this.chatC=chatC;
	}
}
