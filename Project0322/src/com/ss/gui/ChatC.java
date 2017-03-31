package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatC extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	private ChatA chatA;
	private ChatB chatB;
	
	public ChatC(){
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(15);
		
		this.add(scroll);
		p_south.add(t_input);
		
		t_input.addKeyListener(this);
		this.add(p_south, BorderLayout.SOUTH);
		this.add(scroll);
		setBounds(700,100,300,400);
		setVisible(true);
	}

	public void setChatA(ChatA chatA) {
		this.chatA = chatA;
	}

	public void setChatB(ChatB chatB) {
		this.chatB = chatB;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			area.append(t_input.getText()+"\n");
			chatA.area.append(t_input.getText() + "\n");
			chatB.area.append(t_input.getText() + "\n");
			t_input.setText("");	
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
