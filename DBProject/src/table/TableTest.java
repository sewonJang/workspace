/*
 	swing�� ������Ʈ �� �����ͺ��̽��� ��� ������ �ð�ȭ�ϱ⿡ ����ȭ�� ������Ʈ�� �ִµ� 
 	JTable �̴�. 
  */
package table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableTest extends JFrame {
	JTable table;
	JScrollPane scroll;
	
	String driver="org.mariadb.jdbc.Driver";
	String url="jdbc:mariadb://localhost:3306/db0331";
	String user="root";
	String password;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs; // select���� ��츸 �ʿ���
					//�� ����� ��ƾ� �ϹǷ�...
	
	String[][] data;
	String[] column={"member_id","name","age"};
	int i=0;
	
	public TableTest() {
		roadData();
		//setLayout(new FlowLayout());
		table = new JTable(data,column);
		scroll = new JScrollPane(table);
		
		add(scroll);
		
		//pack();
		setSize(500, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	//���ڵ� ä���ֱ�
	//���̺��� �����ϱ� ����, mariadb �����Ͽ� 
	//member���̺��� ���ڵ带 �������迭�� ��Ƴ���
	//��? JTable�� �������� �μ��� ������ �迭�� ���Ǵϱ�
	public void roadData(){
		/*
		 	1�ܰ�-����̹� �ε�
		 	2�ܰ�-����
		 	3�ܰ�-���ϴ� ��������
		 	4�ܰ�-�����ͺ��̽� �ݱ�
		 */
		data= new String[3][column.length];
		try {
			Class.forName(driver);
			System.out.println("�ε� ����");
			con =DriverManager.getConnection(url, user, password);
			if(con!=null){
			System.out.println("���� ����");
			
			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				String member_id=Integer.toString(rs.getInt("member_id"));
				String name = rs.getString("name");
				String age = Integer.toString(rs.getInt("age"));
				
				data[i][0]=member_id;
				data[i][1]=name;
				data[i][2]=age;
				i++;
			}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("�ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}finally{
			if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		}
		
	}
	public static void main(String[] args) {
		new TableTest();

	}

}
