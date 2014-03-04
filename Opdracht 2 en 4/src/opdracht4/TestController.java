package opdracht4;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;

public class TestController implements SensorListener{
	public static void main(String[] args) {
		new TestController();
	}

	public TestController() {
		MyUltrasonicSensor mus = new MyUltrasonicSensor(SensorPort.S4);
		SensorHandler sh = SensorHandler.getInstance();
		sh.addSensor(mus);
		mus.addListener(this);
		Button.waitForAnyPress();
	}

	@Override
	public void stateChanged(float oldValue, float newValue) {
		LCD.clear();
		System.out.println("oldValue: " + oldValue);
		System.out.println();
		System.out.println("newValue: " + newValue);
		
	}
}
