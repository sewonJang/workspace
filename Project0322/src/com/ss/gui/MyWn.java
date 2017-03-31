package com.ss.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyWn extends JFrame {
	JTextField txt_north;
	JButton bt;
	JPanel p_north;
	MyActionListener myAl;
	MyKeyListener myKl;

	public MyWn() {
		txt_north = new JTextField(15);
		bt = new JButton("»Æ¿Œ");
		p_north = new JPanel();

		p_north.add(txt_north);
		p_north.add(bt);
		add(p_north);

		setBounds(100, 100, 200, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		myAl = new MyActionListener();
		myKl = new MyKeyListener();

		myAl.setMyWn(this);
		bt.addActionListener(myAl);
		txt_north.addKeyListener(myKl);
	}

	public static void main(String[] args) {
		new MyWn();
	}

}
