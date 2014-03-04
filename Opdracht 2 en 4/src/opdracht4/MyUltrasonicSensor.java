package opdracht4;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class MyUltrasonicSensor extends UltrasonicSensor {
	private float value;
	private SensorListener listener;

	public MyUltrasonicSensor(SensorPort sp) {
		super(sp);
	}

	public void updateState() {
		if (listener != null) {
			float tmp = getDistance();
			if (tmp != value) {
				listener.stateChanged(value, tmp);
				value = tmp;
			}
		}
	}

	public void addListener(SensorListener listener) {
		this.listener = listener;
	}
}
