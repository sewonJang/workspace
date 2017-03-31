package page;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainApp extends JFrame implements ActionListener {
	JButton[] menu = new JButton[3];
	JPanel p_north,p_center;
	URL[] url = new URL[3];
	String[] path = { "/login.png", "/content.png", "/etc.png" };
	
	//페이지들을 보유한다.
	LoginForm loginForm;
	Content cnt;
	Etc etc;
	ArrayList<JPanel> jp = new ArrayList<JPanel>();
		
	public MainApp() {
		p_north = new JPanel();
		p_center = new JPanel();
		//로그인 폼 생성
		
		jp.add(new LoginForm());
		jp.add(new Content());
		jp.add(new Etc());
		
		for (int i = 0; i < path.length; i++) {
			url[i] = this.getClass().getResource(path[i]);
			menu[i] = new JButton(new ImageIcon(url[i]));
			p_north.add(menu[i]);
			menu[i].addActionListener(this);
		}
		
		add(p_north, BorderLayout.NORTH);
		p_center.add(jp.get(0));
		p_center.add(jp.get(1));
		p_center.add(jp.get(2));
		
		add(p_center);
		
		setSize(700, 800);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		for(int i=0; i<menu.length; i++){
			if(obj==menu[i]){
				jp.get(i).setVisible(true);
			}
			else
			{
				jp.get(i).setVisible(false);
			}
		}
	
	}

	public static void main(String[] args) {
		new MainApp();
	}


}
