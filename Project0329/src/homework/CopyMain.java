package homework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class CopyMain extends JFrame implements ActionListener, Runnable{
	JProgressBar bar;
	JButton bt_open, bt_save, bt_copy;
	JTextField t_open, t_save;

	JFileChooser chooser;
	FileInputStream fis;
	FileOutputStream fos;

	File file; // �о���� ����
	
	Thread thread; //���縦 ������ ���� ������ 
						// ���� �޼���� �츮�� �˰� �ִ� �� ����ζ� 
						//�Ҹ��� ���ø����̼��� ��� ����ϴ� ������ �����Ѵ�. ���� ���� ���ѷ�����
						//�����¿� ������ �ؼ��� �ȵȴ�.

	long total;//���������� ��ü �뷮
	
	public CopyMain() {
		bar = new JProgressBar();
		bt_open = new JButton("����");
		bt_save = new JButton("����");
		bt_copy = new JButton("����");

		t_open = new JTextField(30);
		t_save = new JTextField(30);

		chooser = new JFileChooser("C:\\Users\\sewonjang\\Desktop");

		bar.setPreferredSize(new Dimension(400, 40));
		bar.setBackground(Color.YELLOW);
		bar.setString("0%");

		setLayout(new FlowLayout());

		add(bar);
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		add(bt_copy);

		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);

		setSize(450, 200);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();// �̺�Ʈ�� ����Ų �̺�Ʈ�ҽ�(�̺�Ʈ ��ü)
		if (obj == bt_open) {
			open();
		} else if (obj == bt_save) {
			save();
		} else if (obj == bt_copy) {
			//������ ���� ���縦 �������� ���� 
			//�����忡�� ��Ű��
			//������ �����ڿ� Runnable������ü�� �μ��� ������
			//Runnable ��ü���� �������� run() �޼��带 �����Ѵ�.
			thread= new Thread(this);
			thread.start(); //�츮�� run ����
		}
	}

	public void open() {
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			t_open.setText(file.getAbsolutePath());
			total=file.length();
		}
	}

	public void save() {
		int result = chooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			t_save.setText(file.getAbsolutePath());
		}

	}

	public void copy() {
		String save = t_save.getText();

		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(save);
			int data;
			int count=0;
			while (true) {
				data = fis.read();
				count++;
				if (data == -1) break;
				fos.write(data);
				int x=(int)getPercent(count);
				bar.setValue(x);
				bar.setString(x+"%");
			}
			JOptionPane.showConfirmDialog(this, "����Ϸ�");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	public void run() {
		copy();
	}

	public long getPercent(int currentRead){
		return (100*currentRead)/total;
		
	}
	public static void main(String[] args) {
		new CopyMain();

	}



}
