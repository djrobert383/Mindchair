package wk2o2;

public class MyThread extends Thread{
	byte[] data = new byte[1024];
	public boolean isTrue = true;
	private int name;
	
	public MyThread(int i){
		name = i;
	}
	
	public void run(){
		while(isTrue){
			Thread.yield();
		}
	}

	public void stop() {
		this.interrupt();		
	}

	public void setFalse() {
		isTrue = false;
	}
}
