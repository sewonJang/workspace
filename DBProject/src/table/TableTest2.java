/*
 	swing의 컴포넌트 중 데이터베이스의 결과 집합을 시각화하기에 최적화된 컴포넌트가 있는데 
 	JTable 이다. 
 	
 	레코드의 갯수에 따라 배열의 크기를 지정해서 개발해보자
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
	ResultSet rs; // select문일 경우만 필요함
					//왜 결과를 담아야 하므로...
	
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

	//레코드 채워넣기
	//테이블을 생성하기 전에, mariadb 연동하여 
	//member테이블의 레코드를 이차원배열에 담아놓자
	//왜? JTable의 생성자의 인수로 이차원 배열이 사용되니깐
	public void roadData(){
		/*
		 	1단계-드라이버 로드
		 	2단계-접속
		 	3단계-원하는 쿼리수행
		 	4단계-데이터베이스 닫기
		 */
		
		try {
			Class.forName(driver);
			System.out.println("로드 성공");
			con =DriverManager.getConnection(url, user, password);
			if(con!=null){
			System.out.println("접속 성공");
			
			String sql = "select * from emp";
			pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rs=pstmt.executeQuery();
			
			//rs를 last()로 보내고, 위치를 묻자
			rs.last();
			rs.getRow();
			int total=rs.getRow();
			
			data= new String[total][column.length];
			//rs 원상복구
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
			System.out.println("로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속 실패");
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
