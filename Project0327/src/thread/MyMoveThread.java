/*
 	������ ������ ��� �� ������ 
 */
package thread;

public class MyMoveThread extends Thread{
	AnyMain anyMain;
	//�����ڴ� ���� ������ �ڵ带 run�� ����
	//jvm�� run�� �˾Ƽ� ȣ�����ش�. 
	public MyMoveThread(AnyMain anyMain){
		this.anyMain = anyMain;
		
	}
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			anyMain.move();
		}
	}

}
