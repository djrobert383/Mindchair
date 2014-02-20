package src.Opdracht3;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;


public class Main implements ButtonListener {
	public Main(){
		
		Button.ESCAPE.addButtonListener(this);
		while(running){
			
			brickMe();
			
			try {  Thread.sleep((int)(Math.random() * 200));
			} catch (InterruptedException e) {}
		}
		
	
	}
	
	public static boolean running = true;
	public static void brickMe(){
		String print = "Bricked";
		int xAs = 0;
		int yAs = 0;
		int xTemp;
		
		
		xTemp = (int) ((Math.random()*15)-5);
		
		while (xTemp < 0){
			xTemp = (int) ((Math.random()*15)-5);
		}
		
		xAs = xTemp;
		yAs = (int) (Math.random()*8);
		
		LCD.drawString(print, xAs, yAs);
		
		
		
	}
	
	public static void main(String[] args){	
		new Main();
	}

	@Override
	public void buttonPressed(Button b) {
		if(b.equals(Button.ESCAPE)){
			running= false;
		}
		
	}

	@Override
	public void buttonReleased(Button b) {
		// TODO Auto-generated method stub
		
	}
	
}
	


