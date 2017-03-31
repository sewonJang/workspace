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
	
	ArrayList list= new ArrayList(); //�� ���� �迭! ũ�⸦ ������� �ʾƵ� �ǰ�, ��ü���� �ٷ�
	/*
	 ���ݱ��� ����ؿԴ� �迭�� �뷮�� �����͸� �����ְ� ó���Կ� �־ ��û�� �̵��� ��Դ�
	 but c,c#,�ڹٿ� ���� ���뤷���α׷������� �迭 ������ �� ũ�⸦ �ݵ�� ����ؾ� �Ѵٴ�
	 Ư¡�� +����� �ڷ����� �����Ǿ�� �Ѵ� ������ ������ �������� ��������. �ڹٿ����� �뷮�� ��ü(��)�� ó���ϴµ� ������ ���̺귯���� 
	 �����ϴµ� �̷��� ���̺귯���� ������ �÷��� �����ӿ��̶�� �ϰ�, java.util ��Ű���� ���ִ�.
	 
	 �ڹ��� collection framework���� �����ϴ� ��ü�� �� ���� ����ϱ� ������ ��� ����Ѵٴ� ���� ��û�� ���̴�. 
	 ������ ���� �׶����� ������ ���� �����ϸ� �ȴ�.... 
	 
	 ����!!!!!!!!!
	 �迭���� �޸�, �÷��� �����ӿ��� ����� �Ǵ� ���� ���� �繰�� ��ü�� �������̴�. 
	 �迭�� ��������, ��Ƽ� ó���ϴµ� �����ϴ�.
	 */
	
	public ButtonArray() {
		bt1 = new JButton("��ư");
		bt2 = new JButton("�÷� ä����");
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
				//��� ��ư�� ������� ���� ����
				setColor();
			}
		});
		
		setSize(320, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	//��ư ���� �޼���
	//������ �A ������?
	//�̺�Ʈ�� �����Ͽ� ������ �ۼ��ϸ�
	//�̺�Ʈ ����� ���濡 ���� ������ �ջ�
	}
	public void createButton(){
		count++;
		JButton bt=new JButton(Integer.toString(count));
		list.add(bt); //1�� �߰�
		System.out.println("������� �������� "+list.size());
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
