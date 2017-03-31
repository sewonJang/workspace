package file;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FileWindow extends JFrame {
	MyIcon folder_on;
	MyIcon folder_off;
	MyPanel mp;

	public FileWindow() {
		setLayout(new FlowLayout());
		// Uniformed Resource Locator: URL
		folder_off = new MyIcon(this.getClass().getResource("/forder_off.png"), 50, 50);
		folder_on = new MyIcon(this.getClass().getResource("/forder_on.png"), 50, 50);

		ArrayList<String> list = createFile();
		ArrayList<JButton> btList = new ArrayList<JButton>();

		for (int i = 0; i < list.size(); i++) {
			String dirName = list.get(i);
			mp = new MyPanel(dirName, folder_off);
			btList.add(mp.bt);
			mp.bt.setBorderPainted(false);
			mp.bt.setContentAreaFilled(false);
			mp.bt.setFocusPainted(false);
			mp.bt.setOpaque(false);
			add(mp);
		}

		
		setSize(600, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// ���ϴ� ����� ���� ���丮/���� ���ϱ�
	public ArrayList createFile() {
		File file = new File("c:/");
		File[] flist = file.listFiles();
		ArrayList<String> dirList = new ArrayList<String>();
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isDirectory()) {
				// ���丮�� �߰ߵɶ����� ����Ʈ �߰�
				dirList.add(flist[i].getName());
			}
		}
		return dirList;
	}

	public static void main(String[] args) {
		new FileWindow();

	}

}
