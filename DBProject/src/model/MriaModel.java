/*
 	�� ��ü�� JTable�� �����ڿ��� �䱸�ϴ� 
 	��Ʈ�ѷ� ��ü�̴�.
 	�� ��ü�� ������ �����ΰ� ������ �и�����
 	�ִ� �߰��� ����
 */
package model;

import javax.swing.table.AbstractTableModel;

public class MriaModel extends AbstractTableModel {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	String[][] data=new String[3][2];
	public MriaModel() {
		data[0][0]="û����";
		data[0][1]="�����ٳ�";
		data[0][2]="2000";

		
		data[1][0]="����";
		data[1][1]="�÷���";
		data[1][2]="5000";
		
		
		data[2][0]="����Ű";
		data[2][1]="�ȭ";
		data[2][2]="3000";
	
		

		
	}
	//�÷��� ������ ��ȯ

	public int getColumnCount() {
		return data[0].length;
	}
	
	//���ڵ��� ������ ��ȯ
	public int getRowCount() {
		return data.length;
	}
	
	//Ư�� ��ġ�� ���� ��ȯ
	public Object getValueAt(int row, int col) {
		return "¥���";
	}

}
