/*
	�츮�� ������� �����ͺ��̽� ��ǰ��
	��� DBMS�̴�.
	DB(�����)MS(�����ý���)-��Ʈ��ũ ����̶�, ���������� �����ϴ�.
	
	���� ������� ��Ʈ��ũ ���������� TCP/IP ����̹Ƿ�, �������� ȣ��Ʈ�� �����Ϸ���
	�� ȣ��Ʈ�� �ּҸ� �˾ƾ� �ϴµ� ����� TCP/IP������ IP �ּҸ� �˾ƾ� �Ѵ�. 
	user ������������ �˾ƾ� �Ѵ�. 
*/
package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestMain {

	public static void main(String[] args) {
		// 1�ܰ�-����Ŭ�� �ڹٰ� ������ �� �ִ� �ڵ尡 ����ִ� jar������ �޸𸮿�
		// �ε��ؾ� �Ѵ�. �̷� �����ͺ��̽� ���� jar ������ �ڹٿ����� ����̹���� �Ѵ�.
		// ����̹��� db �����翡�� �����Ѵ�.
		// oracle -->����Ŭ��
		// mysql-->����Ŭ��
		// mssql -->MS��
		// 2�ܰ� ����Ŭ�� ��������

		// ����̹� Ŭ���� �ε�
		// ��Ʈ�������� �־�� ��
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "batman", "1234");
			if (con != null) {
				System.out.println("���Ӽ���");

				// ���� ������ ������ ���̺� insert
				String sql = "insert into company(company_id,brand) values(seq_company.nextval, '����Ű')";
				// ������ ������ ���ؼ��� �������� �����ϴ�
				// ��ü�� �̿��ؾ� �ϴµ�, �� ��ü�� �ٷ�
				// PreparedStatement �������̽� �̴�.
				pstmt = con.prepareStatement(sql);
				int result = pstmt.executeUpdate(); // ������ ���� �޼���
				// �� ������ ���࿡ ���� �ݿ��� ���ڵ��� ���� ��ȯ���ش�.
				if (result == 1) {
					System.out.println("�Է� ����");
				} else {
					System.out.println("�Է� ����");
				}
			} else {
				System.out.println("���ӽ���");
			}

		} catch (ClassNotFoundException e) {

			System.out.println("����̹��� ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// ��Ʈ���� DB �����۾� �Ŀ� �ݵ��
			// �ݴ� ó���� �ؾ��Ѵ�.!!
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
