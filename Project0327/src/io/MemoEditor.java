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
	ImageIcon icon;//일반 클래스
	
	String ori="C:/java_workspace2/Project0327/res/memo.txt";//원본
	String dest="C:/java_workspace2/Project0327/res/memo_copy.txt";//다른 파일의 저장경로
	FileInputStream fis;
	FileOutputStream fos;
	
	InputStreamReader reader;// 문자 기반의 입력 스트림
	OutputStreamWriter writer;// 
	PrintWriter writer2; //문자기반의 출력스트림
	
	BufferedReader buffr;//버퍼처리된 문자기반 입력스트림
	
	public MemoEditor(){
		icon = new ImageIcon("C:\\java_workspace2\\Project0327\\res\\forder_on.png");
		bt_open = new JButton(icon);
		bt_save= new JButton("저장");
		
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
		
		//버튼 2개 내부익명으로 가자
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
	
	//열기
	public void open(){
		try {
			fis= new FileInputStream(ori);
			//문자기반 스트림에는 문자인코딩 속성을 지정할 수 있다. 
			reader = new InputStreamReader(fis,"utf-8");
			buffr= new BufferedReader(reader);
			String data;
		
			while(true){
				
				data=buffr.readLine();//1byte 읽어들인다.
			
				if(data==null) break;
				area.append(data+"\n");
			}
			} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "파일을 찾을수 없습니다.");
			e.printStackTrace();//개발자를 위한 로그 정보
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//저장하기
	public void save(){
		try {
			//FileOutputStream은 지정한 경로의 파일을
			//생성해 버린다.(크기는 0바이트인 empty빈 파일)
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
			//열어놓은 스트림은 전부 닫는 처리
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
