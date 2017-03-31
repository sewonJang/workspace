/*
 	swing�� ������Ʈ �� �����ͺ��̽��� ��� ������ �ð�ȭ�ϱ⿡ ����ȭ�� ������Ʈ�� �ִµ� 
 	JTable �̴�. 
 	
 	���ڵ��� ������ ���� �迭�� ũ�⸦ �����ؼ� �����غ���
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

public class TableTest2 extends JFrame {
	JTable table;
	JScrollPane scroll;
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs; // select���� ��츸 �ʿ���
					//�� ����� ��ƾ� �ϹǷ�...
	
	String[][] data;
	String[] column={"empno","ename","job","mgr","hiredate","sal","comm","deptno"};
	int i=0;
	
	public TableTest2() {
		roadData();
		//setLayout(new FlowLayout());
		table = new JTable(data,column);
		scroll = new JScrollPane(table);
		
		add(scroll);
		
		//pack();
		setSize(800, 600);
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
		
		try {
			Class.forName(driver);
			System.out.println("�ε� ����");
			con =DriverManager.getConnection(url, user, password);
			if(con!=null){
			System.out.println("���� ����");
			
			String sql = "select * from emp";
			pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rs=pstmt.executeQuery();
			
			//rs�� last()�� ������, ��ġ�� ����
			rs.last();
			rs.getRow();
			int total=rs.getRow();
			
			data= new String[total][column.length];
			//rs ���󺹱�
			rs.beforeFirst();
			
			while(rs.next()){
				
				String empno=Integer.toString(rs.getInt("empno"));
				String name = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = Integer.toString(rs.getInt("mgr"));
				String hiredate = rs.getString("hiredate");
				String sal = rs.getString("sal");
				String comm = rs.getString("comm");
				String deptno = rs.getString("deptno");
				
				data[i][0]=empno;
				data[i][1]=name;
				data[i][2]=job;
				data[i][3]=mgr;
				data[i][4]=hiredate;
				data[i][5]=sal;
				data[i][6]=comm;
				data[i][7]=deptno;
	
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
		new TableTest2();

	}

}
