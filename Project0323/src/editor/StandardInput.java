/*
	1.��Ʈ�� ���⼺�� ���� �з�
	-�Է�, ���
	2.��Ʈ���� ������ ó������� ���� �з�
		(1) ����Ʈ ��� ��Ʈ�� 
			(����½� 1byte �� ó��)
		(2) ���ڱ�� ��Ʈ��
			(����½� 2byte�� ��� ������ �� �ִ� ��Ʈ��)
			����!! 2byte�� �аų�, ���°� �ƴϴ�!! 
			���ڱ�ݽ�Ʈ���� ����Ģ
			�Է½�Ʈ�� - ~~Reader ����
			��½�Ʈ��- ~~Writer ����
		(3) ���� ��Ʈ��
*/
package editor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StandardInput {

	public static void main(String[] args) {
		InputStream is=System.in; //�߻�Ŭ������ new�� �ȵȴ� �� ��� �ý����� �޾Ƴ�
		InputStreamReader reader=null;
		reader = new InputStreamReader(is);
		
		int data;
		try {
			
			data= reader.read();	//1byte
			System.out.print((char)data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
