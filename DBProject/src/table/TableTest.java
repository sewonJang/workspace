/*
 	swing의 컴포넌트 중 데이터베이스의 결과 집합을 시각화하기에 최적화된 컴포넌트가 있는데 
 	JTable 이다. 
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
	ResultSet rs; // select문일 경우만 필요함
					//왜 결과를 담아야 하므로...
	
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
		data= new String[3][column.length];
		try {
			Class.forName(driver);
			System.out.println("로드 성공");
			con =DriverManager.getConnection(url, user, password);
			if(con!=null){
			System.out.println("접속 성공");
			
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
		new TableTest();

	}

}
