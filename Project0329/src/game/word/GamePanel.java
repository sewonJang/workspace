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
	JPanel p_west; // 왼쪽 컨트롤 영역
	JPanel p_center; // 단어 그래픽 처리 영역

	JLabel la_user; // 게임 로그인 유저명
	JLabel la_score; // 게임 점수
	Choice choice; // 단어 선택 드랍박스
	JTextField t_input; // 게임 입력창
	JButton bt_start, bt_pause, bt_stop; // 게임 시작 버튼

	GameWindow gameWindow;

	FileInputStream fis;
	InputStreamReader reader; // 파일을 대상으로 문자스트림
	BufferedReader buffr; // 문자기반 버퍼 스트림
	String res = "C:\\java_workspace2\\Project0329\\res/";

	ArrayList<String> wordList = new ArrayList<String>();
	ArrayList<Word> words = new ArrayList<Word>();

	Thread thread;

	boolean flag = true;
	boolean isDown=true;
	int y = 100;// 단어의 현재 y축 값;

	public GamePanel(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
		setLayout(new BorderLayout());

		p_west = new JPanel();

		// 이 영역은 지금부터 그림을 그리는 영역입니다.
		p_center = new JPanel() {
			public void paintComponent(Graphics g) {
				// 먼저 지우기
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 750, 700);
				g.setColor(Color.BLUE);
				for (int i = 0; i < words.size(); i++) {
					words.get(i).render(g);
				}
			}
		};

		la_user = new JLabel("장세원 님");
		la_score = new JLabel("0");
		choice = new Choice();
		t_input = new JTextField(10);
		bt_start = new JButton("Start");
		bt_pause = new JButton("Pause");
		bt_stop = new JButton("종료");

		p_west.setPreferredSize(new Dimension(150, 700));
		p_west.setBackground(Color.PINK);

		choice.setPreferredSize(new Dimension(135, 30));
		choice.add("주제를 선택하세요");
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

		// 리스너 연결
		bt_start.addActionListener(this);
		bt_pause.addActionListener(this);
		bt_stop.addActionListener(this);
		
		//텍스트 필드와 리스너 연결
		
		t_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					//화면에 존재하는 words와 입력값 비교하여
					//맞으면, words에서 객체 삭제
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

	// 단어 읽어 오기
	public void getWord() {
		String name = choice.getSelectedItem();
		choice.getSelectedIndex();
		try {
			fis = new FileInputStream(res + name);
			reader = new InputStreamReader(fis,"utf-8");
			buffr = new BufferedReader(reader);
			
			//기존에 wordList를 비운다.
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

	// 게임 시작
	public void startGame() {
		if (thread == null) {
			flag = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	// 게임 중지 or 재시작
	public void pauseGame() {
		isDown=!isDown;
	}

	/*
	 * --결국 처음으로 돌아가자 1.wordList(단어들이 들어있는) 비우기 2.words(Word 인스턴스가 들어있는) 비우기
	 * 3.choice 초기화 (index=0); 4.flag=false; 5.thread=null; thread를 null로 다시 초기화
	 */
	// 게임 종료
	public void stopGame() {
		wordList.removeAll(wordList);
		words.removeAll(words);
		choice.select(0); // 첫번째 요소 강제 선택
		flag = false; // while문 중지목적
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
				// 모든 단어들에 대해서 tick()
				for (int i = 0; i < words.size(); i++) {
					words.get(i).tick();
				}
				// 모든 단어들에 대해서 render()
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
