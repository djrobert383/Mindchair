package Opdracht3;

import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Main extends Thread{
	
	public int screenX = 100;
	public int screenY = 64;	
	public int currentX = 50;
	public int currentY = 32;
	public boolean loop = true;
	public boolean opneer = true;
	public boolean tekenen = true;
	
	boolean [] [] display = new boolean[screenX] [screenY];
	
	public static void main(String[] args){
		new Main();
	}
	
	public Main(){
		Thread tekenen = new Thread(new Runnable(){public void run(){knoppen();}});
		Thread knipperen = new Thread(new Runnable(){public void run(){knipperen();}});
		tekenen.start();
		knipperen.start();
		
	}
	
	public void knoppen(){
		while(loop){
			if (!(Button.readButtons() > 12)){
				if (Button.ESCAPE.isDown()){
					if (!opneer){
						opneer = true;
					}
					else{
						opneer = false;
					}
				}
				
				else if (Button.RIGHT.isDown()){
					if (!opneer){
						if (tekenen){
							draw();
						}
						moveCursor("rechts");
					}
					else {
						if (tekenen){
							draw();
						}
						moveCursor("omhoog");
					}
				}
				
				else if (Button.LEFT.isDown()){
					if (!opneer){
						if (tekenen){
							draw();
						}
						moveCursor("links");
					}
					else {
						if (tekenen){
							draw();
						}
						moveCursor("omlaag");
					}
				}
				
				else if (Button.ENTER.isDown()){
					if (tekenen){
						tekenen = false;
					}
					else {
						tekenen = true;
					}
				}
			}
			
			else{
				loop = false;
			}
		}

	}
	
	public void knipperen(){
		while (loop){
			LCD.setPixel(currentX, currentY, 1);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LCD.setPixel(currentX, currentY, 0);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void draw(){
		if (!(display [currentX] [currentY])){
			LCD.setPixel(currentX, currentY, 1);
			display [currentX][currentY] = true;
		}
		else{
			LCD.setPixel(currentX, currentY, 0);
			display [currentX][currentY] = false;
		}
	}
	
	public void newCursor(){
		streepOmhoog();
		streepRechts();
		streepLinks();
		streepOmlaag();
	}
	
	public void moveCursor(String knopNaam){
		if (knopNaam == "omhoog"){
			deleteCursor();
			currentX = currentX + 1;
			streepOmhoog();
			streepRechts();
			streepLinks();
			streepOmlaag();
		}
		
		if (knopNaam == "rechts"){
			deleteCursor();
			currentY = currentY + 1;
			streepOmhoog();
			streepRechts();
			streepLinks();
			streepOmlaag();
		}
		
		if (knopNaam == "links"){
			deleteCursor();
			currentY = currentY - 1;
			streepOmhoog();
			streepRechts();
			streepLinks();
			streepOmlaag();
		}
		
		if (knopNaam == "omlaag"){
			deleteCursor();
			currentX = currentX - 1;
			streepOmhoog();
			streepRechts();
			streepLinks();
			streepOmlaag();
		}
	}
	
	public void deleteCursor(){
		if (!display[currentX][currentY + 1]){
			LCD.setPixel(currentX, currentY + 1, 0);
		}
		if (!display[currentX][currentY + 2]){
			LCD.setPixel(currentX, currentY + 2, 0);
		}
		if (!display[currentX][currentY + 3]){
			LCD.setPixel(currentX, currentY + 3, 0);
		}
		
		
		if (!display[currentX + 1][currentY]){
			LCD.setPixel(currentX + 1, currentY, 0);
		}
		if (!display[currentX+ 2][currentY]){
			LCD.setPixel(currentX + 2, currentY, 0);
		}
		if (!display[currentX + 3][currentY]){
			LCD.setPixel(currentX + 3, currentY, 0);
		}
		
		
		if (!display[currentX - 1][currentY]){
			LCD.setPixel(currentX - 1, currentY, 0);
		}
		if (!display[currentX - 2][currentY]){
			LCD.setPixel(currentX - 2, currentY, 0);
		}
		if (!display[currentX - 3][currentY]){
			LCD.setPixel(currentX - 3, currentY, 0);
		}
		
		
		if (!display[currentX][currentY - 1]){
			LCD.setPixel(currentX, currentY - 1, 0);
		}
		if (!display[currentX][currentY - 2]){
			LCD.setPixel(currentX, currentY - 2, 0);
		}
		if (!display[currentX][currentY - 3]){
			LCD.setPixel(currentX, currentY - 3, 0);
		} 
		
	}
	
	public void streepOmhoog(){
		LCD.setPixel(currentX, currentY + 1, 1);
		LCD.setPixel(currentX, currentY + 2, 1);
		LCD.setPixel(currentX, currentY + 3, 1);
	}
	
	public void streepRechts(){
		LCD.setPixel(currentX + 1, currentY, 1);
		LCD.setPixel(currentX + 2, currentY, 1);
		LCD.setPixel(currentX + 3, currentY, 1);
	}
	
	public void streepLinks(){
		LCD.setPixel(currentX - 1, currentY, 1);
		LCD.setPixel(currentX - 2, currentY, 1);
		LCD.setPixel(currentX - 3, currentY, 1);
	}
	
	public void streepOmlaag(){
		LCD.setPixel(currentX, currentY - 1, 1);
		LCD.setPixel(currentX, currentY - 2, 1);
		LCD.setPixel(currentX, currentY - 3, 1);
	}
}
