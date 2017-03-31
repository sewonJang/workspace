package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonArray extends JFrame {
	JButton bt1, bt2;
	JPanel p1, p2;
	int count;
	
	ArrayList list= new ArrayList(); //얘 완전 배열! 크기를 명시하지 않아도 되고, 객체만을 다룸
	/*
	 지금까지 사용해왔던 배열은 대량의 데이터를 순서있게 처리함에 있어서 엄청난 이득을 줘왔다
	 but c,c#,자바와 같은 응용ㅇ프로그램에서는 배열 생성시 그 크기를 반드시 명시해야 한다는
	 특징은 +선언시 자료형이 결정되어야 한는 점등이 오히려 유연성이 떨어진다. 자바에서는 대량의 객체(★)를 처리하는데 유용한 라이브러리를 
	 제공하는데 이러한 라이브러리를 가리켜 컬렉션 프레임웍이라고 하고, java.util 패키지에 모여있다.
	 
	 자바의 collection framework에서 제공하는 객체는 그 수가 상당하기 때문에 모두 사용한다는 것은 멍청한 짓이다. 
	 업무에 따라 그때마다 적절한 것을 선택하면 된다.... 
	 
	 주의!!!!!!!!!
	 배열과는 달리, 컬렉션 프레임웍의 대상이 되는 것은 오직 사물인 객체에 한정적이다. 
	 배열과 공통점은, 모아서 처리하는데 유용하다.
	 */
	
	public ButtonArray() {
		bt1 = new JButton("버튼");
		bt2 = new JButton("컬러 채인지");
		p1 = new JPanel();
		p2 = new JPanel();
		count = 0;
		setLayout(new BorderLayout());
		p1.add(bt1);
		p1.add(bt2);
		add(p1, BorderLayout.NORTH);
		
	
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createButton();
			}
		});
		
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//모든 버튼을 대상으로 배경색 변경
				setColor();
			}
		});
		
		setSize(320, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	//버튼 생성 메서드
	//별도로 뺸 이유는?
	//이벤트에 의존하여 로직을 작성하면
	//이벤트 방식의 변경에 의해 로직도 손상
	}
	public void createButton(){
		count++;
		JButton bt=new JButton(Integer.toString(count));
		list.add(bt); //1건 추가
		System.out.println("현재까지 누적수는 "+list.size());
		p2.add(bt);
		p2.updateUI();//refresh
		add(p2);
	}
	
	public void setColor(){
		for(int i=0; i<list.size(); i++){
			JButton bt=(JButton)list.get(i);
			bt.setBackground(Color.YELLOW);
	
		}
		
	}

	public static void main(String[] args) {
		new ButtonArray();

	}

}
