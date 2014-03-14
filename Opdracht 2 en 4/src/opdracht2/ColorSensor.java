package opdracht2;

import lejos.nxt.SensorPort;

public class ColorSensor extends lejos.nxt.ColorSensor {

	private int zero = 1023;
	private int hundred = 0;

	public ColorSensor(SensorPort port) {
		super(port);
	}

	public void calibrateLow() {
		// TODO: Should these methods save calibrated data in static memory?
		zero = port.readRawValue();
	}

	public void calibrateHigh() {
		hundred = port.readRawValue();
	}
}
