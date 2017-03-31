package homeWork;

public class CountThread1 extends Thread{
	CountApp capp;
	
	public CountThread1(CountApp capp){
		this.capp=capp;
	}
	
	public void count(){
		capp.num2++;
		capp.lb_right.setText(""+capp.num2);
	}
	
	public void run() {
		try {
			while(true){
			Thread.sleep(100);
			count();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
