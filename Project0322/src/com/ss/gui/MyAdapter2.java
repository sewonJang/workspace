package com.ss.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyAdapter2 extends KeyAdapter {
	AdapterTest adapterTest;

	public void keyReleased(KeyEvent e) {
		
	}

	public void setAdapterTest(AdapterTest adapterTest) {
		this.adapterTest = adapterTest;
	}

}
