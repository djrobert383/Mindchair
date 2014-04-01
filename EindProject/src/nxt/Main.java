package nxt;

import java.util.ArrayList;

import lejos.nxt.SensorPort;

public class Main {
	public static void main(String[] args) {
		ColorSensor cs = new ColorSensor(SensorPort.S1, Position.Left);
		LightSensor ls = new LightSensor(SensorPort.S2, Position.Right);
		UltraSonicSensor us = new UltraSonicSensor(SensorPort.S4);
		
		ArrayList<UpdatingSensor> sensors = new ArrayList<UpdatingSensor>();
		sensors.add(cs);
		sensors.add(ls);
		sensors.add(us);
		new CalibreerController(sensors).calibreer();
		//LineFollowController lfc = new LineFollowController(cs, ls, us);
	}
}
