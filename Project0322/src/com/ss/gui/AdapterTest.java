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

		bt = new JButton("����ư");
		add(bt);
		setSize(250, 350);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// .java ������ ����� ���� ���, Ŭ���� �ڵ�
		// ��ü�� �޼����� �μ���, Ŭ������ �������
		// �ٷ� ������ �� �ִ�.
		// Anonymous inner class
		// �����͸�Ŭ������ ����ϴ� ����?
		// .java vs �����͸�
		// .java�� ���������� �����ҽ����� �ۼ��ϴ� ����
		// ������ �ڵ��� ���뼺�� �ִ�. ������,
		// GUI���α׷��� ��� Ư�� �̺�Ʈ ����
		// �ڵ�� Ư�� Ŭ������ �������̱� ������
		// ���뼺�� ����� ��������. �� ���
		// �����ڰ� .java���� ������, �μ��� ����
		// ��ü�� �Ѱܹ޴� ���� �ؾ��ұ�?
		// �ش�)��ȸ�� �ڵ�� ����!!�� ���� Ŭ������
		// �Ϻη� Ŭ������ ������� �������
		txt_f.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txt_a.append(txt_f.getText() + "\n");
					txt_f.setText("");
				}
			}

		});
		//�����͸� Ŭ������ ����
		//�����͸� �޼��� �ȿ��� �ڽ��� ������ �ڵ�ȿ���
		//�ܺ�Ŭ������ ��������� ���� ó�� �� �� �ִ�.
		//�ڰ��� ���� ���� 
		//��������� ������ �� �ִٴ� ���ε�,
		//���� �����ڰ� ���������� �����͸�����
		//����ϰ����Ҷ��� �� ���������� final�� 
		//����Ǿ� �־�� �Ѵ�. 
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("������");
				
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AdapterTest();
	}

}
