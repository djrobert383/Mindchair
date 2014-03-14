package opdracht4;

import lejos.nxt.SensorPort;

public class UltrasonicSensor extends lejos.nxt.UltrasonicSensor implements
		UpdatingSensor {
	private float value;
	private SensorListener listener;

	public UltrasonicSensor(SensorPort sp) {
		super(sp);
	}

	public void updateState() {
		if (listener != null) {
			float tmp = getDistance();
			if (tmp != value) {
				listener.stateChanged(this, value, tmp);
				value = tmp;
			}
		}
	}

	public void addListener(SensorListener listener) {
		this.listener = listener;
	}
	
	/**
	 * constructor for testcontroller
	 * @return String
	 */
	@Override
	public String getSensorType() {
		return "Ultrasonic";
	}
}
