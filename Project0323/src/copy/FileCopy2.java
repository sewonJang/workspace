/*���� ó���� ����
-������ ������ ���� (�� �������� �ý��� ��� ����)

�Ϲ������� ���α׷��� ���� ����� �� ���� ��Ȳ�� ������ ������� �Ѵ�.
sun������ ������ ���� ���� �з���
1. ���α׷��Ӱ� ��ó�� �� ���� �Ұ��׷��� ����
	Error
2. ���α׷��Ӱ� ��ó�� �� �ִ� ���� (���� ��)
	�ڹ��� ���� ������ �ٷ� "����"
	sun������ �� ���ܸ� ��Ȳ�� ���� ü������ Ŭ������ 
	�����ϰ� �ִ�. 

	�� ���� ��ü���� �ٽ� ũ�� 2���� �������� �з�
		(1)������ Ÿ�ӿ� ����ó���� �����ϴ� ���
			checked Exception
		(2)������ Ÿ�ӿ� ����ó���� �������� �ʴ� ���
			Unchecked Exception = Runtime Exception

3.
*/
package copy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


class FileCopy2{
	FileInputStream fis;// ������ ��������� �Է½�Ʈ��
	FileOutputStream fos; //������ ��������� ��½�Ʈ��
	public FileCopy2(){
		//�Ʒ��� �ڵ�� ����, ������ �߻��� �� �ִ� ���ɼ��� �ִ� �ڵ��̴�..
		//���� �����ڰ� ������ �� �ۼ��������� �Ұ��ϰ�, Ư���� ������ġ��
		//�����ϱ⸦ �����Ѵ�.
		try{
			fis=new FileInputStream("C:/java_workspace2/Project0323/res/sc.png");
			fos=new FileOutputStream("C:/java_workspace2/Project0323/data/sc_copy.png");
			//System.out.println("���Ͽ� ��Ʈ�� �����߾��");
			
			int data;
			while(true){
				data=fis.read(); //1byte �� �;� ����;
				fos.write(data); //1byte ����;

				if(data==-1) break;
				System.out.println(data);
				
			}
		}
		catch(FileNotFoundException e){//������ �߻��ϸ� ����ΰ� �� �������� �����Ѵ�.
					//catch���� �����ϰ� �Ǹ� ���α׷��� ���������ᰡ 
					//���� ������ ��������� �ϰ� �ȴ�. ����ڿ��� �ȳ��ϴ� �뵵��
					//catch���� ����ϰ� �ȴ�.
					System.out.println("������ ã�� �� �����ϴ�.");
		
		}
		catch(IOException e){
			System.out.println("������ ���� �� �����ϴ�.");
		}finally{
			//finally�� �����ϸ�,
			//try���� �����ϴ�, catch���� �����ϴ� ����ΰ� ������ �̿���
			//����ΰ� ������ �� ������ ���ļ� ����.
			//finally �ڵ��� ������
			/*
				�ַ� database������ ��Ʈ�� ����
				�������θ� ������ ������ �ڿ��� �ݰų� ������
				�Ϸ��� try���̴� catch���� �����ϴ� ��� ����
				������ ���İ����� �ڵ� ������ �α�����
			*/

				try{
					//��Ʈ�� ���� ����!!
						if(fis!=null){fis.close();}
						if(fos!=null){fos.close();}
					}
				catch(IOException e){
				
				}
			}

		//��� ������ ������ ����
	
	}
	public static void main(String[] args){
		new FileCopy2();
	}
}
