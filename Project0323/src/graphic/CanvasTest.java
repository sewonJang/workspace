/*
	그림 그려질 목적으로 지원되는 객체인
	Canvas에 그림을 그려보자
	왜 그려야하나
	캔버스는 컨테이너 처럼 아무것도 없기 때문
	비어있다. 빈 도화지를 표현한 객체이므로
*/
package graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CanvasTest extends JFrame {
	Canvas can; //텅빈 도화지
	Toolkit kit; //자바에서 이미지를 얻으려면 툴킷 객체를 이용해야 한다(sun 사가)
	Image img; //추상클래스라서 new 못함
					//kit으로 부터 얻어와야 함
	public CanvasTest(){
		kit=Toolkit.getDefaultToolkit();
		img=kit.getImage("C:/html_workspace/images/mario.png");
		//피곤하면, 여기서 오버라이드하자!!
		can = new Canvas(){
			//paint 메서드는 사실상 행위에 불과하며
			//어떤 그림을 그릴지를 결정하는 객체는
			//Graphics 객체이다.
			public void paint(Graphics g) {
				g.drawLine(0, 0, 200, 300);
				g.drawRect(200, 300, 200, 200);
				g.drawRoundRect(100, 100, 200, 200, 200, 200);
				g.drawImage(img, 0, 0, this);
	
	
			}
		};
		can.setBackground(Color.BLUE);
		add(can);	
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new CanvasTest();

	}

}
