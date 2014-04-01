package nxt;

import java.util.ArrayList;

import lejos.nxt.SensorPort;

public class LightSensor extends lejos.nxt.LightSensor implements
		UpdatingSensor {

	private float value;
	private ArrayList<LightSensorListener> listeners = new ArrayList<LightSensorListener>();
	private Position position;

	/**
	 * 
	 * @param sensorport
	 *            the port the lightsensor is connected to on the nxt
	 * @param position
	 *            the position on the robot of the sensor
	 */
	public LightSensor(SensorPort sensorport, Position position) {
		super(sensorport);
		this.position = position;
		SensorHandler.getInstance().addSensor(this);
	}

	/**
	 * check if the input of the lightsensor has changed, if so tell it to all
	 * the listeners
	 */
	public void updateState() {
		float tmp = getNormalizedLightValue();
		if (tmp != value) {
			if (listeners.size() < 0) {
				for (LightSensorListener listener : listeners) {
					listener.lightSensorChanged(position, this, value, tmp);
				}
			}
			value = tmp;
		}

	}

	/**
	 * add a listener to the list of listeners so the sensor knows who to tell
	 * it has changed
	 * 
	 * @param listener
	 */
	public void addListener(LightSensorListener listener) {
		listeners.add(listener);
	}

	/**
	 * remove the listener so it won't get any updates
	 * 
	 * @param listener
	 */
	public void deleteListener(LightSensorListener listener) {
		boolean tmp = listeners.remove(listener);

		if (tmp) {
			System.out.println("removed");
		} else {
			System.err.print("not removed");
		}
	}

	public int getNormalizedLightValue() {
		return getLightValue();
	}

	/**
	 * 
	 * @return returns the type of the sensor
	 */
	public SensorType getSensorType() {
		return SensorType.Lightsensor;
	}

}
