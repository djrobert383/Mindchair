package nxt;

import java.util.ArrayList;

import lejos.nxt.SensorPort;

public class LightSensor extends lejos.nxt.LightSensor {
	private float value;
	private ArrayList<LeftSensorListener> leftlisteners = new ArrayList<LeftSensorListener>();
	private ArrayList<RightSensorListener> rightlisteners = new ArrayList<RightSensorListener>();

	public LightSensor(SensorPort sensorport) {
		super(sensorport);
	}

	public void updateState() {
	}

	public void addRightListener() {

	}

	public void addLeftListener() {

	}

}
