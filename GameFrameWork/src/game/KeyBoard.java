/*
	플레이어의 움직임을 제어하자!!
	
*/
package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoard extends KeyAdapter {
	Player player;
	Bullet bullet;

	// 키보드 누르면
	public KeyBoard(Player player) {
		this.player = player;

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			player.velX = -2;
			break;
		case KeyEvent.VK_RIGHT:
			player.velX = +2;
			break;
		case KeyEvent.VK_UP:
			player.velY = -2;
			break;
		case KeyEvent.VK_DOWN:
			player.velY = +2;
			break;
		case KeyEvent.VK_SPACE:
			player.fire();
			break;
		}
	}

	// 키보드 떼면
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			player.velX = 0;
			break;
		case KeyEvent.VK_RIGHT:
			player.velX = 0;
			break;
		case KeyEvent.VK_UP:
			player.velY = 0;
			break;
		case KeyEvent.VK_DOWN:
			player.velY = 0;
			break;
		}
	}
}
