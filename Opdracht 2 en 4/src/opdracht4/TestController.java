package opdracht4;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;

public class TestController implements SensorListener {
	public static void main(String[] args) {
		new TestController();
	}

	public TestController() {
		SensorHandler sh = SensorHandler.getInstance();

		MyUltrasonicSensor mus = new MyUltrasonicSensor(SensorPort.S4);
		MyColorSensor cs = new MyColorSensor(SensorPort.S2);

		sh.addSensor(cs);
		sh.addSensor(mus);

		cs.addListener(this);
		mus.addListener(this);
		Button.waitForAnyPress();
	}

	@Override
	public void stateChanged(UpdatingSensor updatingsensor, float oldValue,
			float newValue) {
		if (updatingsensor.getSensorType().equals("Color")) {
			LCD.drawString("Color", 0, 0);
			LCD.drawString(("oldValue: " + oldValue), 0, 1);
			LCD.drawString(("newValue: " + newValue), 0, 2);
		}

		if (updatingsensor.getSensorType().equals("Ultrasonic")) {
			LCD.drawString("Ultrasonic", 0, 5);
			LCD.drawString(("oldValue: " + oldValue), 0, 6);
			LCD.drawString(("newValue: " + newValue), 0, 7);
		}

	}
}
