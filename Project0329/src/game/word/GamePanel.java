package game.word;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JPanel implements ItemListener, Runnable, ActionListener {
	JPanel p_west; // ���� ��Ʈ�� ����
	JPanel p_center; // �ܾ� �׷��� ó�� ����

	JLabel la_user; // ���� �α��� ������
	JLabel la_score; // ���� ����
	Choice choice; // �ܾ� ���� ����ڽ�
	JTextField t_input; // ���� �Է�â
	JButton bt_start, bt_pause, bt_stop; // ���� ���� ��ư

	GameWindow gameWindow;

	FileInputStream fis;
	InputStreamReader reader; // ������ ������� ���ڽ�Ʈ��
	BufferedReader buffr; // ���ڱ�� ���� ��Ʈ��
	String res = "C:\\java_workspace2\\Project0329\\res/";

	ArrayList<String> wordList = new ArrayList<String>();
	ArrayList<Word> words = new ArrayList<Word>();

	Thread thread;

	boolean flag = true;
	boolean isDown=true;
	int y = 100;// �ܾ��� ���� y�� ��;

	public GamePanel(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
		setLayout(new BorderLayout());

		p_west = new JPanel();

		// �� ������ ���ݺ��� �׸��� �׸��� �����Դϴ�.
		p_center = new JPanel() {
			public void paintComponent(Graphics g) {
				// ���� �����
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 750, 700);
				g.setColor(Color.BLUE);
				for (int i = 0; i < words.size(); i++) {
					words.get(i).render(g);
				}
			}
		};

		la_user = new JLabel("�弼�� ��");
		la_score = new JLabel("0");
		choice = new Choice();
		t_input = new JTextField(10);
		bt_start = new JButton("Start");
		bt_pause = new JButton("Pause");
		bt_stop = new JButton("����");

		p_west.setPreferredSize(new Dimension(150, 700));
		p_west.setBackground(Color.PINK);

		choice.setPreferredSize(new Dimension(135, 30));
		choice.add("������ �����ϼ���");
		choice.addItemListener(this);

		p_west.add(la_user);
		p_west.add(choice);
		p_west.add(t_input);
		p_west.add(bt_start);
		p_west.add(bt_pause);
		p_west.add(bt_stop);
		p_west.add(la_score);

		add(p_west, BorderLayout.WEST);
		setBackground(Color.CYAN);
		add(p_center);
		setPreferredSize(new Dimension(900, 700));

		// ������ ����
		bt_start.addActionListener(this);
		bt_pause.addActionListener(this);
		bt_stop.addActionListener(this);
		
		//�ؽ�Ʈ �ʵ�� ������ ����
		
		t_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					//ȭ�鿡 �����ϴ� words�� �Է°� ���Ͽ�
					//������, words���� ��ü ����
					String value= t_input.getText();
					for(int i=0; i<words.size(); i++){
						if(value.equals(words.get(i).name)){
							words.remove(i);
						}
					}
				}
				
			}
		});

		setVisible(false);
		getCateroge();

	}

	public void getCateroge() {
		File file = new File(res);
		File[] flist = file.listFiles();
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isFile()) {
				String name = flist[i].getName();
				String[] arr = name.split("\\.");
				if (arr[1].equals("txt")) {
					choice.add(name);
				}
			}
		}
	}

	// �ܾ� �о� ����
	public void getWord() {
		String name = choice.getSelectedItem();
		choice.getSelectedIndex();
		try {
			fis = new FileInputStream(res + name);
			reader = new InputStreamReader(fis,"utf-8");
			buffr = new BufferedReader(reader);
			
			//������ wordList�� ����.
			wordList.removeAll(wordList);

			String data = null;

			while (true) {

				data = buffr.readLine();
				if (data == null) {
					break;
				}
				
				wordList.add(data);
			}
			createWord();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (buffr != null) {
				try {
					buffr.close();
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

	// ���� ����
	public void startGame() {
		if (thread == null) {
			flag = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	// ���� ���� or �����
	public void pauseGame() {
		isDown=!isDown;
	}

	/*
	 * --�ᱹ ó������ ���ư��� 1.wordList(�ܾ���� ����ִ�) ���� 2.words(Word �ν��Ͻ��� ����ִ�) ����
	 * 3.choice �ʱ�ȭ (index=0); 4.flag=false; 5.thread=null; thread�� null�� �ٽ� �ʱ�ȭ
	 */
	// ���� ����
	public void stopGame() {
		wordList.removeAll(wordList);
		words.removeAll(words);
		choice.select(0); // ù��° ��� ���� ����
		flag = false; // while�� ��������
		thread = null;
	}

	public void itemStateChanged(ItemEvent e) {

		getWord();
	}

	public void run() {
		while (flag) {
			try {
				thread.sleep(500);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (isDown) {
				// ��� �ܾ�鿡 ���ؼ� tick()
				for (int i = 0; i < words.size(); i++) {
					words.get(i).tick();
				}
				// ��� �ܾ�鿡 ���ؼ� render()
				p_center.repaint();
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == bt_start) {
			startGame();
		} else if (obj == bt_pause) {
			pauseGame();
		} else if (obj == bt_stop) {
			stopGame();
		}
	}

	public void createWord() {
		for (int i = 0; i < wordList.size(); i++) {
			String name = wordList.get(i);
			Word word = new Word(name, i * 50, y);
			words.add(word);
		}
	}

}
