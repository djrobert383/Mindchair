package opdracht4;

import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;

public class MyColorSensor extends ColorSensor implements UpdatingSensor{
	private float value;
	private SensorListener listener;

	public MyColorSensor(SensorPort sp) {
		super(sp);
		setFloodlight(Color.WHITE);
	}

	public void updateState() {
		if (listener != null) {
			float tmp = getRawLightValue();
			if (tmp != value) {
				listener.stateChanged(this, value, tmp);
				value = tmp;
			}
		}
	}

	public void addListener(SensorListener listener) {
		this.listener = listener;
	}

	@Override
	public String getSensorType() {
		return "Color";
	}

}
