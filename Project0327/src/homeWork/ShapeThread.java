/*���̴�, �簢���̴�, � ������ ǥ���� ��ü
 	�̴� ��� �� Ŭ������ �ڽ����� ����
 	�� ������ Ư¡�� �����Ƿ�
 */
package homeWork;

import java.awt.Color;
import java.awt.Graphics;

abstract public class ShapeThread extends Thread {
	int x, y;
	int width, height;
	Graphics g;
	int interval;
	
	public ShapeThread(int x, int y, int width, int height, int interval, Graphics g){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.interval= interval;
		this.g = g;
		
		start();
	}

	abstract public void render();

	public void run() {
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			render();
		}
	}
}
