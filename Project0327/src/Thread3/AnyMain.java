
package Thread3;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//개발자가 쓰레드를 상속하여 개발 할 수 있으나
//이미 다른 클래스의 자식일 경우, 상속은 불가
//이럴때 사용할 수 있는 객체가 바로 
//Runnalble 인터페이스이다. 
public class AnyMain extends JFrame implements Runnable{
		JButton bt;
		Canvas can;
		int x,y;
		Thread thread;//내부익명 스타일로 개발
		
		public AnyMain(){
			//Runnable인 객체를 인수로 넘긴다
			//그러면, run 메서드의 호출은 Runnable
			//을 재정의한 객체의 run을 호출한다.
			
			thread = new Thread(this);
			bt = new JButton("옮기기");
			add(bt,BorderLayout.NORTH);
			
			can= new Canvas(){
				@Override
				public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
				}
			};
			
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					thread.start();
				}
			});
			
			can.setBackground(Color.yellow);
			add(can);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			setSize(700,500);
			
		}
		public void move(){
				
				x+=5;
				y+=5;
				can.repaint();
		}
		public void run() {
			while(true){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				move();
			}
		}
	public static void main(String[] args) {
	new AnyMain();
	}

	

}
