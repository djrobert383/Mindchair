package nxt;

import lejos.nxt.SensorPort;

public class Main {
	public static void main(String[] args) {
		ColorSensor cs = new ColorSensor(SensorPort.S1, Position.Left);
		LightSensor ls = new LightSensor(SensorPort.S2, Position.Right);
		UltraSonicSensor us = new UltraSonicSensor(SensorPort.S4);
		LineFollowController lfc = new LineFollowController(cs, ls, us);
	}
}
