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

	File file; // 읽어들일 파일
	
	Thread thread; //복사를 실행할 존용 쓰레드 
						// 메인 메서드는 우리가 알고 있는 그 실행부라 
						//불리는 어플리케이션의 운영을 담당하는 역할을 수행한다. 따라서 절대 무한루프나
						//대기상태에 빠지게 해서는 안된다.

	long total;//원본파일의 전체 용량
	
	public CopyMain() {
		bar = new JProgressBar();
		bt_open = new JButton("열기");
		bt_save = new JButton("저장");
		bt_copy = new JButton("복사");

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
		Object obj = e.getSource();// 이벤트를 일으킨 이벤트소스(이벤트 주체)
		if (obj == bt_open) {
			open();
		} else if (obj == bt_save) {
			save();
		} else if (obj == bt_copy) {
			//메인이 직접 복사를 수행하지 말고 
			//쓰레드에게 시키자
			//쓰레드 생성자에 Runnable구현객체를 인수로 넣으면
			//Runnable 객체에서 재정의한 run() 메서드를 수행한다.
			thread= new Thread(this);
			thread.start(); //우리꺼 run 수행
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
			JOptionPane.showConfirmDialog(this, "복사완료");
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
