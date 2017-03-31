package progressbar;

import java.awt.Dimension;

import javax.swing.JProgressBar;

public class BarThread1 extends Thread {
	JProgressBar bar;
	int count;
	int interval;

	public BarThread1(JProgressBar bar, int interval) {
		this.bar = bar;
		this.interval = interval;
		start();
	}

	public void run() {
		try {
			while (true) {
				Thread.sleep(interval);
				count++;
				bar.setValue(count);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
