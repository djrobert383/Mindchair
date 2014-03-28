package nxt;

import java.util.ArrayList;

public class SensorHandler extends Thread{
	private SensorHandler singleton;
	private ArrayList<UpdatingSensor> sensors = new ArrayList<UpdatingSensor>();

	private SensorHandler() {

	}
	public static SensorHandler getInstance(){
		return null;
	}
	public void run(){
		
	}
	public void addSensor(UpdatingSensor updatingSensor){
		
	}
}
