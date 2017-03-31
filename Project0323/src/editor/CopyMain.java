package editor;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.io.File;
public class CopyMain extends JFrame implements ActionListener{
	JButton bt_open, bt_area, bt_save;
	JTextField  t_open, t_save;
	FileInputStream fis; //파일을 대상으로한 입력 스트림
	FileOutputStream fos;//파일을 대상으로한 출력스트림
	File file1, file2;
	
	//파일 탐색기를 처리하는 객체
	JFileChooser chooser;

	public CopyMain(){
			bt_open = new JButton("열기");
			bt_area = new JButton("저장 위치");
			bt_save = new JButton("복사");
			
			t_open = new JTextField("",30);
			t_save = new JTextField("",30);
			
			setLayout(new FlowLayout());
			add(bt_open);
			add(t_open);
			add(bt_area);
			add(t_save);
			add(bt_save);
			
			//버튼과 리스너와 연결
			bt_open.addActionListener(this);
			bt_area.addActionListener(this);
			bt_save.addActionListener(this);

			//파일 추저를 미리 올려놓자
			chooser = new JFileChooser("C:");

			setSize(475,150);
			setVisible(true);
			//setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		
	}
	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource(); //이벤트 소스를 반환 받는다!!
		if(obj==bt_open){
			System.out.println("열기");
			open();
		}
		else if(obj==bt_area){
			saveArea();
		}
		else if(obj==bt_save){
			System.out.println("복사");
			copy();
		}
	}

	//파일열기
	public void open(){
		int returnVal=chooser.showOpenDialog(this);
		  if(returnVal == JFileChooser.APPROVE_OPTION) { //상수는 인간에게 직관성을 부여해준다. 
			file1= chooser.getSelectedFile();
			 String x= file1.getPath();
			t_open.setText(x);
	}
	}
	public void saveArea(){
		int returnVal=chooser.showSaveDialog(this);
		  if(returnVal == JFileChooser.APPROVE_OPTION) {
			 file2= chooser.getSelectedFile();
			 String x= file2.getPath();
			t_save.setText(x);
    }
		
	}

	//복사하기
	public void copy(){
		//윈본파일에 스트림 생성하여, 데이터를 들이 마시자
		//들어오는 데이터를 목적 파일에 내려쓰자
		String oriPath=t_open.getText();
		String desPath=t_save.getText();
		try{
			fis=new FileInputStream(oriPath);
			fos=new FileOutputStream(desPath);
			int data=-1;
			
			while(true){
				data=fis.read(); //현재 실행중인 프로그램으로 1byte 읽어들임!!
				if(data==-1) break;
				fos.write(data);
			}
			JOptionPane.showMessageDialog(this,"복사완료.");
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(this,"파일을 찾을 수 없습니다.");
		}catch(IOException e){
			JOptionPane.showMessageDialog(this,"IO작업중에 에러방생.");
		}finally{
			//stream을 닫자
			//try문안에서 닫을 경우 문제점
			try{
				//객체가 메모리에 올라왔다면...
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			}catch(IOException e){
			}
		}
	}


	
	public static void main(String[] args) {
		new CopyMain();

	}

}
