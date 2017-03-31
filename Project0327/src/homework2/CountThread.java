package homework2;

import javax.swing.JLabel;

public class CountThread extends Thread {
	JLabel la;
	int interval;
	int count;

	public CountThread(JLabel la, int interval) {
		this.la = la;
		this.interval = interval;
		
		this.start();
	}

	public void run() {
		// Ư�� ���� ���� 1�� ������Ű��, ������ �ӵ����
		while (true) {
			try {
				Thread.sleep(interval);
				count++;
				la.setText(Integer.toString(count));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
