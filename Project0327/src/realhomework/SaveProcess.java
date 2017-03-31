package realhomework;

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

public class SaveProcess extends JFrame {
	JButton bt_open;
	JButton bt_save;
	JButton bt_copy;
	JTextField t_open;
	JTextField t_save;
	JProgressBar bar;
	JFileChooser chooser;
	FileInputStream fis;
	FileOutputStream fos;
	File file1;
	File file2;
	int total;//원본파일의 전체 용량
	Thread thread;

	public SaveProcess() {
		bar = new JProgressBar();
		bt_open = new JButton("열기");
		bt_save = new JButton("저장");
		bt_copy = new JButton("복사");
		t_open = new JTextField(25);
		t_save = new JTextField(25);
		chooser = new JFileChooser("C:");
		bar.setPreferredSize(new Dimension(350, 40));

		add(bar);
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		add(bt_copy);

		thread = new Thread() {
			public void run() {
				copy();
			}
		};

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

		bt_copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start();
			}
		});

		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400, 600);

	}

	public void save() {
		int returnVal = chooser.showSaveDialog(SaveProcess.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file2 = chooser.getSelectedFile();
			String x = file2.getPath();
			t_save.setText(x);
		}
	}

	public void open() {
		int returnVal = chooser.showOpenDialog(SaveProcess.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file1 = chooser.getSelectedFile();
			String x = file1.getPath();
			t_open.setText(x);
		}
	}

	public void copy() {
		String org = t_open.getText();
		String sav = t_save.getText();
		try {
			fis = new FileInputStream(org);
			fos = new FileOutputStream(sav);
			int data;
			int count=0;
			while (true) {
				data = fis.read();
				count++;
				if (data == -1)break;
				fos.write(data);
				int x=(int)getPercent(count);
				bar.setValue(x);
			}
			JOptionPane.showConfirmDialog(this, "복사완료");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fis != null)
					fos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public long getPercent(int currentRead){
		return 100*currentRead/file1.length();
	}
	public static void main(String[] args) {
		new SaveProcess();
	}

}
