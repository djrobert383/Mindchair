package nxt;

import java.util.ArrayList;

import lejos.nxt.SensorPort;

public class ColorSensor extends lejos.nxt.ColorSensor implements UpdatingSensor{
	private float value;
	private ArrayList<LeftSensorListener> leftlisteners = new ArrayList<LeftSensorListener>();
	private ArrayList<RightSensorListener> rightlisteners = new ArrayList<RightSensorListener>();

	public ColorSensor(SensorPort sensorport) {
		super(sensorport);
	}

	public void updateState() {
	}

	public void addRightListener() {

	}

	public void addLeftListener() {

	}
}
