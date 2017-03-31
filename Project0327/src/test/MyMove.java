package test;

import java.awt.Canvas;

public class MyMove extends Thread {
	AnyMain anyMain;
	int x= 0;

	public MyMove(AnyMain anyMain) {
		this.anyMain = anyMain;
		x=5;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			anyMain.move(this.x);
		}

	}
}
