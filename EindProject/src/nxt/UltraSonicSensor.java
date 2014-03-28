package nxt;

import java.util.ArrayList;

import lejos.nxt.SensorPort;

public class UltraSonicSensor extends lejos.nxt.UltrasonicSensor {
	private float value;
	private ArrayList<UltraSonicSensorListener> listeners = new ArrayList<UltraSonicSensorListener>();

	public UltraSonicSensor(SensorPort sensorport) {
		super(sensorport);
	}

	public void updateState() {
	}

	public void addListener() {

	}
}
