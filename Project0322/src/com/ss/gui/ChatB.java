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
	//필요한 객체, 즉 사용할 객체가 있다면 
	//has a 관계로 보유하자 
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
	//외부의 어떤 객체가, 나에게 데이터를 
	//주입시켜줄 수 있는 setter를 준비하자!!
	public void setChatA(ChatA chatA){
		this.chatA=chatA;
	}
	public void setChatC(ChatC chatC){
		this.chatC=chatC;
	}
}
