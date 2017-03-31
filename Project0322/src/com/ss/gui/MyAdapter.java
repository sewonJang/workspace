package com.ss.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyAdapter extends WindowAdapter{

	/*어댑터가 이미 7개를 모두 오버라이드 했기 때문에 우리가
	 구현 강제를 받지 않는 상태이다.
	 이 중에서 원하는 메서드를 또 오버라이드하자
	 */
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
