package io;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame {
	JPanel p_north;
	JButton bt_open, bt_save;
	JTextArea area;
	JScrollPane scroll;
	ImageIcon icon;//�Ϲ� Ŭ����
	
	String ori="C:/java_workspace2/Project0327/res/memo.txt";//����
	String dest="C:/java_workspace2/Project0327/res/memo_copy.txt";//�ٸ� ������ ������
	FileInputStream fis;
	FileOutputStream fos;
	
	InputStreamReader reader;// ���� ����� �Է� ��Ʈ��
	OutputStreamWriter writer;// 
	PrintWriter writer2; //���ڱ���� ��½�Ʈ��
	
	BufferedReader buffr;//����ó���� ���ڱ�� �Է½�Ʈ��
	
	public MemoEditor(){
		icon = new ImageIcon("C:\\java_workspace2\\Project0327\\res\\forder_on.png");
		bt_open = new JButton(icon);
		bt_save= new JButton("����");
		
		p_north = new JPanel();
		area = new JTextArea();
		scroll = new JScrollPane(area);
		 
		p_north.add(bt_open);
		p_north.add(bt_save);
		setLayout(new BorderLayout());
		
		bt_open.setBorderPainted(false);
		bt_open.setContentAreaFilled(false);
		bt_open.setFocusPainted(false);
		bt_open.setOpaque(false);
		
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		//��ư 2�� �����͸����� ����
		bt_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		
	bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,600);
		setVisible(true);
	}
	
	//����
	public void open(){
		try {
			fis= new FileInputStream(ori);
			//���ڱ�� ��Ʈ������ �������ڵ� �Ӽ��� ������ �� �ִ�. 
			reader = new InputStreamReader(fis,"utf-8");
			buffr= new BufferedReader(reader);
			String data;
		
			while(true){
				
				data=buffr.readLine();//1byte �о���δ�.
			
				if(data==null) break;
				area.append(data+"\n");
			}
			} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "������ ã���� �����ϴ�.");
			e.printStackTrace();//�����ڸ� ���� �α� ����
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//�����ϱ�
	public void save(){
		try {
			//FileOutputStream�� ������ ����� ������
			//������ ������.(ũ��� 0����Ʈ�� empty�� ����)
			fos = new FileOutputStream(dest);
			writer = new OutputStreamWriter(fos,"utf-8");
			writer.write(area.getText());
			//writer2 = new PrintWriter(fos);
			//writer2.write(area.getText());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//������� ��Ʈ���� ���� �ݴ� ó��
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			if(fos!=null){
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
			}
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new MemoEditor();
	}

}
