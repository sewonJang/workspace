package com.ss.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AdapterTest extends JFrame {
	JTextField txt_f;
	JTextArea txt_a;
	MyAdapter2 ma;
	JButton bt;

	public AdapterTest() {
		txt_f = new JTextField(20);
		txt_a = new JTextArea(15, 20);
		setLayout(new FlowLayout());

		add(txt_f);
		add(txt_a);

		bt = new JButton("나버튼");
		add(bt);
		setSize(250, 350);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// .java 파일을 만들기 싫은 경우, 클래스 코드
		// 자체를 메서드의 인수나, 클래스의 멤버변수
		// 바로 대입할 수 있다.
		// Anonymous inner class
		// 내부익명클래스를 사용하는 이유?
		// .java vs 내부익명
		// .java를 물리적으로 원본소스까지 작성하는 이유
		// 이유는 코드의 재사용성에 있다. 하지만,
		// GUI프로그래밍 등에서 특히 이벤트 구현
		// 코드는 특정 클래스에 종속적이기 때문에
		// 재사용성이 상당히 떨어진다. 이 경우
		// 개발자가 .java까지 만들어가며, 인수를 통해
		// 객체를 넘겨받는 수고를 해야할까?
		// 해답)일회성 코드로 가자!!즉 현재 클래스에
		// 일부로 클래스를 존재시켜 사용하자
		txt_f.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txt_a.append(txt_f.getText() + "\n");
					txt_f.setText("");
				}
			}

		});
		//내부익명 클래스의 장점
		//내부익명 메서드 안에서 자신을 포함한 코드안에서
		//외부클래스에 멤버변수를 내것 처럼 쓸 수 있다.
		//자격증 시험 문제 
		//멤버변수를 공유할 수 있다는 것인데,
		//만일 개발자가 지역변수를 내부익명내에서
		//사용하고자할때는 그 지역변수를 final로 
		//선언되어 있어야 한다. 
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("눌렀어");
				
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AdapterTest();
	}

}
