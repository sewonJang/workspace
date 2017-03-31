package game.word;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

//�� ������� ũ�Ⱑ �����Ǿ� ���� �ʾƾ� �Ѵ�.
//��?������ �ȿ� ������ �� �г��� �� ũ�⸦ �����ϰ� �ǹǷ�...
//�α��� ������� �۰�, ���Ӻ� ȭ�鿡���� ũ��...
public class GameWindow extends JFrame {
	LoginForm loginForm;
	GamePanel gamePanel;

	JPanel[] page = new JPanel[2];

	public GameWindow() {
		setLayout(new FlowLayout());

		page[0] = new LoginForm(this);
		page[1] = new GamePanel(this);
		add(page[0]);
		add(page[1]);
		
		setPage(0);

		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	// ������ȿ� � �г��� ������ �������ִ� �޼��带 ��������
	public void setPage(int index) {
		for (int i = 0; i < page.length; i++) {
			if (i == index) {
				page[i].setVisible(true);
			} else {
				page[i].setVisible(false);
			}
		}
		setLocationRelativeTo(null);
		pack();// ���빰�� ũ�⸸ŭ ������ ũ�⸦ �����Ѵ�.
	}

	public static void main(String[] args) {
		new GameWindow();

	}

}
