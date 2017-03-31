/*
 	OS�� ���� ���μ������� ���ÿ� �����ϸ鼭 ������ �� �ֵ�,(multi-tasking), �ϳ��� �ڹ� ���α׷� ������
 	������ ��������� ����� ���ÿ� �����ų�� �ִ�. �̷��� ������ ��������� ������� �Ѵ�.  
 	
 	�ڹٴ� �����ڰ� �������� �ʾƵ� �̹� �⺻������ �����Ǵ� ����� �����尡 ������ �̷��� �����带 ������ ���� �������� �Ѵ�.
 	�ᱹ �ڹٴ� ������ ����̴�. 
 */
package thread;

public class ThreadTest {
	//���ξ����� ����, �����ڰ� ���ϴ� ����� ����
	//������ �ϳ� ���� ���ϴ� ���� �۾��� ���Ѻ���!!
	
	//java.lang�� ������
	MyThread thread;

	public ThreadTest(){
		//���ξ�����ʹ� ���������� ����� �� �ִ� ���� ��������� ������
		//�����尡 � ���� ������ �����ڰ� �����ؾ� �ϱ� ������..		
		thread = new MyThread();
		thread.start();
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("��");
		}
	}

	public static void main(String[] args) {
		new ThreadTest();
	}

}
