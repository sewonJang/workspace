/*
	�׸� �׷��� �������� �����Ǵ� ��ü��
	Canvas�� �׸��� �׷�����
	�� �׷����ϳ�
	ĵ������ �����̳� ó�� �ƹ��͵� ���� ����
	����ִ�. �� ��ȭ���� ǥ���� ��ü�̹Ƿ�
*/
package graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CanvasTest extends JFrame {
	Canvas can; //�ֺ� ��ȭ��
	Toolkit kit; //�ڹٿ��� �̹����� �������� ��Ŷ ��ü�� �̿��ؾ� �Ѵ�(sun �簡)
	Image img; //�߻�Ŭ������ new ����
					//kit���� ���� ���;� ��
	public CanvasTest(){
		kit=Toolkit.getDefaultToolkit();
		img=kit.getImage("C:/html_workspace/images/mario.png");
		//�ǰ��ϸ�, ���⼭ �������̵�����!!
		can = new Canvas(){
			//paint �޼���� ��ǻ� ������ �Ұ��ϸ�
			//� �׸��� �׸����� �����ϴ� ��ü��
			//Graphics ��ü�̴�.
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
