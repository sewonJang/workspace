/*
	���ڵ� ����� �迭�� �������� ����
	���ڵ��� �� ������ �˼��� ����.
*/
package table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Java Data Base Connectivity = �ڹ��� ������ ���̽� ���� ���

public class ResultSetTest {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ResultSetTest() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			if(con!=null){
				String sql="select *from company";
				
				//rs�� Ŀ���� ������, �Ĺ��� ������
				//�����Ӱ� �����̰ų� �Ѳ����� �ǳʶٰ� 
				//�Ϸ��� ��ũ�� ������ ��� �ɼ��� �ο��ؾ��Ѵ�.
				//select���� ��������� ������� ���� ���⸸ �ҰŸ�
				//READ_ONLY��, ������ ���ҰŸ� UPDATEABLE
				//�� ����� SELECT���� ���� ���ڵ�� 
				//�б������̴�. 
				pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rs=pstmt.executeQuery();
				
				//���� ������ ���ڵ�� ������
				rs.last();
				int num=rs.getRow();//���� Ŀ���� ����Ű�� ���ڵ� ��ȣ �� ���ڵ��� ��ġ
				System.out.println(num);
				
				//rs.getRow();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//���ڵ�� ��ü�� �̿��Ͽ� �� ���ڵ��
	//�˾Ƹ��� ����
	public static void main(String[] args) {
		 new ResultSetTest();
	}

}
