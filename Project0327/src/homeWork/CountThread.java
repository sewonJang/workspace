package homeWork;

public class CountThread extends Thread{
	CountApp capp;
	
	public CountThread(CountApp capp){
		this.capp=capp;
	}
	
	public void count(){
		capp.num1++;
		capp.lb_left.setText(""+capp.num1);
	}
	
	public void run() {
		try {
			while(true){
			Thread.sleep(500);
			count();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
