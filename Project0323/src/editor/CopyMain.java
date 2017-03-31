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
	FileInputStream fis; //������ ��������� �Է� ��Ʈ��
	FileOutputStream fos;//������ ��������� ��½�Ʈ��
	File file1, file2;
	
	//���� Ž���⸦ ó���ϴ� ��ü
	JFileChooser chooser;

	public CopyMain(){
			bt_open = new JButton("����");
			bt_area = new JButton("���� ��ġ");
			bt_save = new JButton("����");
			
			t_open = new JTextField("",30);
			t_save = new JTextField("",30);
			
			setLayout(new FlowLayout());
			add(bt_open);
			add(t_open);
			add(bt_area);
			add(t_save);
			add(bt_save);
			
			//��ư�� �����ʿ� ����
			bt_open.addActionListener(this);
			bt_area.addActionListener(this);
			bt_save.addActionListener(this);

			//���� ������ �̸� �÷�����
			chooser = new JFileChooser("C:");

			setSize(475,150);
			setVisible(true);
			//setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		
	}
	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource(); //�̺�Ʈ �ҽ��� ��ȯ �޴´�!!
		if(obj==bt_open){
			System.out.println("����");
			open();
		}
		else if(obj==bt_area){
			saveArea();
		}
		else if(obj==bt_save){
			System.out.println("����");
			copy();
		}
	}

	//���Ͽ���
	public void open(){
		int returnVal=chooser.showOpenDialog(this);
		  if(returnVal == JFileChooser.APPROVE_OPTION) { //����� �ΰ����� �������� �ο����ش�. 
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

	//�����ϱ�
	public void copy(){
		//�������Ͽ� ��Ʈ�� �����Ͽ�, �����͸� ���� ������
		//������ �����͸� ���� ���Ͽ� ��������
		String oriPath=t_open.getText();
		String desPath=t_save.getText();
		try{
			fis=new FileInputStream(oriPath);
			fos=new FileOutputStream(desPath);
			int data=-1;
			
			while(true){
				data=fis.read(); //���� �������� ���α׷����� 1byte �о����!!
				if(data==-1) break;
				fos.write(data);
			}
			JOptionPane.showMessageDialog(this,"����Ϸ�.");
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(this,"������ ã�� �� �����ϴ�.");
		}catch(IOException e){
			JOptionPane.showMessageDialog(this,"IO�۾��߿� �������.");
		}finally{
			//stream�� ����
			//try���ȿ��� ���� ��� ������
			try{
				//��ü�� �޸𸮿� �ö�Դٸ�...
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
