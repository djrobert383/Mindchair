package nxt;

import java.util.ArrayList;

import lejos.nxt.SensorPort;

public class ColorSensor extends lejos.nxt.ColorSensor implements
		UpdatingSensor {
	private float value;
	private Position position;
	private ArrayList<LightSensorListener> listeners = new ArrayList<LightSensorListener>();
	private int _zero = 1023;
	private int _hundred = 0;

	/**
	 * 
	 * @param sensorport
	 *            the port the colorsensor is connected to on the nxt
	 * @param position
	 *            the position on the robot of the sensor
	 */
	public ColorSensor(SensorPort sensorport, Position position) {
		super(sensorport);
		this.position = position;
		setFloodlight(Color.RED);
		setFloodlight(true);
		SensorHandler.getInstance().addSensor(this);
	}

	/**
	 * @see UpdatingSensor.updateState()
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

	public void calibrateLow(int low) {
		_zero = low;
	}

	public void calibrateHigh(int high) {
		_hundred = high;
	}

	public int getNormalizedLightValue() {
		if (_hundred == _zero)
			return 0;
		return 100 * (getRawLightValue() - _zero) / (_hundred - _zero);
	}

	/**
	 * 
	 * @return returns the type of the sensor
	 */
	public SensorType getSensorType() {
		return SensorType.Colorsensor;
	}
}
