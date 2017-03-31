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
		bt_prov = new JButton("◀");
		bt_next = new JButton("▶");
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
				// 경고창을 띄우는 법
				//JOptionPane.showMessageDialog(this, "다음사진");
				//ActionEvent는 클릭뿐만 아니라, 여러행위를
				//아우르는 이벤트 객체이다. 따라서
				//버튼만 ActionEvent를 일으키는 게 아니다.
				//그래서 e.getSouce()호출하면, 어떤 컴포넌트가
				//이벤트를 일으켰는지 예측할 수 없으므로
				//Object형으로 반환해 준다.
				
				/* implements를 이용한 방법
				Object obj=e.getSource();//이벤트를 일으킨 컴포넌트
				JButton btn=(JButton)obj;
				if(btn==bt_prov){
					JOptionPane.showMessageDialog(this,"안녕");
				}
				else if(btn==bt_next){
					
				}
				*/
			//	JOptionPane.showMessageDialog(bt_prov, "ㅎㅇ");
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
		
		//개발자는 paint 메서드를 호출할 수 없다.
		//paint는 언제 호출되나??
		//유저가 해당 컴포넌트의 변경을 가할때
		//스스로 호출된다.
		//따라서 버튼을 누르게 되면, 켄버서의 변경
		//을 가한적이 없기 떄문에 paint메서드는
		//호출되지않는다.
		//해결책) 켄버서의 paint 메서드를 강제
		//해야 하지만, 호출불가 이기 때문에 
		//간접 호출해야 한다. 
		//시스템한테 paint 호출해달라고 요청해야 한다. 
		//repaint()->update()->paint()
		//update메서드는 기존 화면을 싹지운다.
		//paint() 메서드가 그림을 다시 그린다.
		//따라서 이미지 용량이 큰 경우엔 우리 눈엔
		//깜빡거리는 효과가 나는 것이다. 
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
