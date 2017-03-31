package homeWork;

import java.awt.Color;
import java.awt.Graphics;

public class RectThread extends ShapeThread{

	public RectThread(int x, int y, int width, int height, int interval, Graphics g) {
		super(x, y, width, height, interval, g);
	}
	public void render(){
		//화면 지우기
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 700, 600);
		x+=2;
		//원하는 도형 그리기
		g.setColor(Color.red);
		g.drawRect(x, y, width, height);
	}
	
}
