package com.ss.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
	MyWn myWn;

	@Override
	public void actionPerformed(ActionEvent e) {
		myWn.txt_north.setText("�������");
	}

	public void setMyWn(MyWn myWn) {
		this.myWn = myWn;
	}
}
