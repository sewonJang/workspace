/*
 	버튼 클래스는 final로 선언되어 있지 않으므로 당연히 상속이 가능하다.
 */
package graphic;

import java.awt.Graphics;

import javax.swing.JButton;

public class MyButton extends JButton{
	//상속관계시 부모의 생성자는 물려지지 않는다.
	public MyButton(String title){
		super(title);//부모의 생성자 호출
	}
	//모든 컴포넌트는 스스로를 그리므로,
	//이때 사용되는 메서드가 paint 메서드이며
	//이 메서드를 개발자가 오버라이드 한다면
	//개발자가 버튼을 그리게 된다.!!
	//sun에서 제공하는 컴포넌트 중 개발자가 
	//그대로 사용해야할 것이 있고, 개발자가 주도하여
	//그래픽 처리를 해야할 것이 있다...
	//컴포넌트 중 개발자가 무언가를 그리는 용도의
	//컴포넌트는 JPanel, Frame등 주로 컨테이너류를
	//대상으로 하자
	//Canvas는 그림 그릴 대상의 목적으로 제공됨
	@Override
	public void paint(Graphics g) {
		System.out.println("그려바");
	}

}
