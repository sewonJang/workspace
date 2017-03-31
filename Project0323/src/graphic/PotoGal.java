package graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PotoGal extends JFrame {
	JPanel p_south;
	JLabel la_north;
	Canvas can;
	JButton bt_prov;
	JButton bt_next;
	Toolkit kit;
	Image img;
	String[] pic;
	int count;

	public PotoGal() {
		count = 0;
		getPic();
		p_south = new JPanel();
		la_north = new JLabel(pic[count]);
		can = new Canvas();
		bt_prov = new JButton("��");
		bt_next = new JButton("��");
		p_south.add(bt_prov);
		p_south.add(bt_next);

		setLayout(new BorderLayout());

		kit = Toolkit.getDefaultToolkit();
		img = kit.getImage(pic[count]);

		can = new Canvas() {
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, this);
			}
		};

		add(la_north, BorderLayout.NORTH);
		add(can, BorderLayout.CENTER);
		add(p_south, BorderLayout.SOUTH);
		setSize(600, 650);
		setVisible(true);

		bt_prov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���â�� ���� ��
				//JOptionPane.showMessageDialog(this, "��������");
				//ActionEvent�� Ŭ���Ӹ� �ƴ϶�, ����������
				//�ƿ츣�� �̺�Ʈ ��ü�̴�. ����
				//��ư�� ActionEvent�� ����Ű�� �� �ƴϴ�.
				//�׷��� e.getSouce()ȣ���ϸ�, � ������Ʈ��
				//�̺�Ʈ�� �����״��� ������ �� �����Ƿ�
				//Object������ ��ȯ�� �ش�.
				
				/* implements�� �̿��� ���
				Object obj=e.getSource();//�̺�Ʈ�� ����Ų ������Ʈ
				JButton btn=(JButton)obj;
				if(btn==bt_prov){
					JOptionPane.showMessageDialog(this,"�ȳ�");
				}
				else if(btn==bt_next){
					
				}
				*/
			//	JOptionPane.showMessageDialog(bt_prov, "����");
				prev();
			}
		});
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
	}

	public void getPic() {
		pic = new String[5];
		pic[0] = "C:/html_workspace/images/item0.png";
		pic[1] = "C:/html_workspace/images/item1.png";
		pic[2] = "C:/html_workspace/images/item2.png";
		pic[3] = "C:/html_workspace/images/item3.png";
	}
	public void next(){
		if(count<pic.length-2){
			count++;
		}
		img = kit.getImage(pic[count]);
		la_north.setText(pic[count]);
		
		//�����ڴ� paint �޼��带 ȣ���� �� ����.
		//paint�� ���� ȣ��ǳ�??
		//������ �ش� ������Ʈ�� ������ ���Ҷ�
		//������ ȣ��ȴ�.
		//���� ��ư�� ������ �Ǹ�, �˹����� ����
		//�� �������� ���� ������ paint�޼����
		//ȣ������ʴ´�.
		//�ذ�å) �˹����� paint �޼��带 ����
		//�ؾ� ������, ȣ��Ұ� �̱� ������ 
		//���� ȣ���ؾ� �Ѵ�. 
		//�ý������� paint ȣ���ش޶�� ��û�ؾ� �Ѵ�. 
		//repaint()->update()->paint()
		//update�޼���� ���� ȭ���� �������.
		//paint() �޼��尡 �׸��� �ٽ� �׸���.
		//���� �̹��� �뷮�� ū ��쿣 �츮 ����
		//�����Ÿ��� ȿ���� ���� ���̴�. 
		can.repaint();
	}
	public void prev(){
		if(count>0){
			count--;
		}
		img = kit.getImage(pic[count]);
		la_north.setText(pic[count]);
		can.repaint();
		
	}

	public static void main(String[] args) {
		PotoGal ptg=new PotoGal();
	}

}
