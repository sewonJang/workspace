/*
	모든 게임은 이 패널안에서 그려질 예정임!!
	아무리 게임의 장면이 다양하더라도, 패널은
	오직 1개만 사용된다.
	
	모든 오브젝트는 결국 이 패널에 그려져야 하므로, 
	이 패널의 paint 메서드의 인수로 전달
	되는 Graphics 객체를 게임에 등장할 모든 오브젝트가
	전달받아야 한다. 
*/
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	public static final int SCALE = 2;

	Thread thread; // 게임 운영 쓰레드
	boolean flag = true; // 게임 가동 여부를 결정하는 변수
	Player player;
	KeyBoard keyBoard;
	ObjectManager objectManager; // 객체 명단 관리자

	public GamePanel() {
		// Thread 선언
		thread = new Thread(this);
		thread.start();
		init(); // 초기값들
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE)); // 크기 지정
	}

	public void init() {
		// 명단관리자 생성
		objectManager = new ObjectManager();

		// 주인공 등장 시키기
		player = new Player(objectManager,ObjectId.Player, 100, 200, 50, 50);
		objectManager.addObject(player);

		// 적군등장!!
		Random r= new Random();
		for (int i = 0; i < 5; i++) {
			int x=r.nextInt((HEIGHT*SCALE-50)-(50)+1)+50;
			int y=r.nextInt((WIDTH*SCALE+500)-(500)+1)+50;
			Enemy enemy = new Enemy(objectManager,ObjectId.Enemy, x, y, 30, 30);
			objectManager.addObject(enemy);
		}
		// 패널과 키보드 리스너 연결
		this.addKeyListener(new KeyBoard(player));
	}

	protected void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		for (int i = 0; i < objectManager.list.size(); i++) {
			GameObject obj = objectManager.list.get(i);
			obj.render(g);
		}
	}

	public void run() {
		while (flag) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < objectManager.list.size(); i++) {
				GameObject obj = objectManager.list.get(i);
				obj.tick();
			}
			repaint(); // paintComponent를 간접 호출
		}
	}
}
