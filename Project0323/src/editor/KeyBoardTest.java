/*
 	
 */

package editor;

import java.io.IOException;
import java.io.InputStream;

public class KeyBoardTest {

	public static void main(String[] args) {
		/*
		  keyboard�� �����ڰ� ���ҋ� ������ �� �ִ� ��Ʈ���� �ƴ϶�, �̹� �ý��ۿ���
		  ��ǻ�� �Ӷ�, �̸� ������ ������
		  �����ڴ� �̹� �����ϴ� ��Ʈ���� ����
		  ��븸 �ϸ� �ȴ�.
		  �ڹٿ����� os�κ��� ��Ʈ���� �̹� ���ͼ� System Ŭ������ ���������
			in ������ �޾Ƴ��ҵ�.
			
			�ڹٴ� �ϵ��� ���� �������� �ʰ� 
			���� �ϵ���� ��ü�� �� �ý����� ��ϴ� OS�� �����ϹǷ�, �ϵ��� ����
			�Է� ��Ʈ���� �ڹٰ� �ƴ� OS�̹� ���� �س��� �ִ�. ���� �ڹ� �� �̿��Ͽ�
			Ű����, ��ĳ��, ��� �Է��ϵ���� ���� ��� ���ؼ��� �� �ϵ��� �˸´� ��Ʈ�� Ŭ������ �����Ǵ°� �ƴ϶� ,
			���� ǥ�� �Է� ��Ʈ���� InputStream�� ���� �ȴ�.
			
		 */
		InputStream is =System.in;
		
		int data;
		try {
			//read() �޼���� ������� �Է��� ���������� �귰 ���¿� ������.
			//�����¶� �����¸� ���Ѵ�. 
			while(true){
			data=is.read(); //1byte �б�
			System.out.print((char)data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
