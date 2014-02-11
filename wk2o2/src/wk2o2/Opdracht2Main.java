package wk2o2;

import java.util.ArrayList;

import lejos.nxt.LCD;

public class Opdracht2Main {
	public static void main(String[] arg){
		
		ArrayList<MyThread> draden = new ArrayList<MyThread>();
		
		int two = 0;
		int i = 0;
		boolean isTrue = true;
		
		while(isTrue){
			
			LCD.clear();			
			
			try{
				draden.add(new MyThread(i));
				draden.get(i).start();
			} catch (Exception e){
			}
			i++;	
			System.out.println(i);
			long bt = 1024;
			long avMem = (Runtime.getRuntime().freeMemory()/bt);
			System.out.println(avMem);
			if(avMem < 3){
				break;
			}
		}
		
		try{
			Thread.sleep(5000);
		} catch (InterruptedException e){
			
		}
		
		LCD.clear();
		
		System.out.println("Done");
		
		try{
			Thread.sleep(1000);
		} catch (InterruptedException e){
		}
		
		for(MyThread e : draden){
			e.setFalse();
		}
	}
}
