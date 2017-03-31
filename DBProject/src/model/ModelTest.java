/*
 	어떤 어플리케이션 개발하던 유지보수성이
 	좋아야 비용이 절감되고, 어플리케이션의 품질도 올라간다. 
 	
 	특히 디자인과 로직이 섞여 잇는 GUI가 잇는 
 	어플리케이션의 겨웅, 유저들의 눈에 보이지 않는 순수로직과, 컴포넌트와 같은 디자인 로직이 마구
 	섞여 있을 경우, 추후 업무 내용이 변경되었을 경우 대응하기가 힘들어지고, 유지 보수성이 떨어진다.
 	이러한 문제는 전산의 고질적인 문제였고, 개발자들이  이미 경험했던 문제들이었다.
 	로직과 디자인(뷰)는 분리시켜 개발했더니 유지보수성이 아주 올라갔다는 경험을 가리켜 MVC 패턴... 
 	
 	JTable은 swing 컴포넌트 중 MVC패턴이 녹아있는 컴포넌트이며, 디자인에 해당하는 
 	Jtable과 로직에 해당하는 DB 데이터를 분리시키기 위해 TableModel이라는 중간 
 	컨트롤러를 제공해 준다. 
 */
package model;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ModelTest extends JFrame{

		JTable table;
		JScrollPane scroll;
		
		public ModelTest() {
			table = new JTable(new OracleModel());
			scroll = new JScrollPane(table);		
			add(scroll);
			pack();
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	public static void main(String[] args) {
		new ModelTest();

	}
}
