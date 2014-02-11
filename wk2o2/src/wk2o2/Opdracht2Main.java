package wk2o2;

import java.util.ArrayList;

public class Opdracht2Main {
	public static void main(String[] arg){
		ArrayList<MyThread> draden = new ArrayList<MyThread>();
		int two = 0;
		int i = 0;
		boolean isTrue = true;
		while(isTrue){
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			i++;
			try{
				draden.add(new MyThread(i));
				draden.get(i).start();
			} catch (Exception e){
			}
						
			System.out.println(i);
			long bt = 1024;
			long avMem = (Runtime.getRuntime().freeMemory()/bt);
			System.out.println(avMem);
			try{
				Thread.sleep(300);
			} catch (InterruptedException e){
			}
			if(avMem < 2){
				break;
			}
		}
		
		try{
			Thread.sleep(5000);
		} catch (InterruptedException e){
			
		}
		
		System.out.println("2");
		System.out.println(Runtime.getRuntime().freeMemory());
		
		try{
			Thread.sleep(1000);
		} catch (InterruptedException e){
		}
		
		for(MyThread e : draden){
			e.setFalse();
		}
	}
}
