package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {
	String driver = "org.mariadb.jdbc.Driver";
	String url = "jdbc:mariadb://localhost:3306/db0331";
	String user = "root";
	String password = "";

	Connection con; // ���� ������ ���� �������̽�
	PreparedStatement pstmt;// ���� ���� ��ü
	ResultSet rs; // �������� select���� ���
	// �������� �����ͺ��̽��� ���̺�� ������
	// ��������� ��Ƴ��� ��ü

	public SelectTest() {
		/*
		 * 1.����̹��� �ε� 2.���� 3.���ϴ� ������ ���� 4.db ���õ� �ڿ� �ݱ�
		 */

		try {
			Class.forName(driver);// ����̹� �ε�
			System.out.println("�ε� ����");

			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("���� ����");
				String sql = "select * from member";
				pstmt = con.prepareStatement(sql);

				// ���� ������ ��ȯ�Ǵ� ��������� ����
				// ��?? select���̴ϱ�
				rs = pstmt.executeQuery();

				// Ŀ�� ��ĭ ����
				while (rs.next()) {
					int member_id = rs.getInt("member_id");
					String name = rs.getString("name");// �ķ��� �ش��ϴ� �� ��ȯ
					int age = rs.getInt("age");
					System.out.println(member_id + ", " + name + ", " + age);
				}
			} else {
				System.out.println("���� ����");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("�ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new SelectTest();
	}

}
