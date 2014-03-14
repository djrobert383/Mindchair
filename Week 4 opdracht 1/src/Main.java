import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.ColorSensor;
import lejos.nxt.ColorSensor.Color;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorConstants;

public class Main implements ButtonListener {

	private static ColorSensor colorSensor;
	private static LightSensor lightSensor;
	private int redOn, redOff, blueOn, blueOff, greenOn, greenOff, bwOn, bwOff,
			thisCase = 0;
	private boolean lampOn = true, busy = false;
	private boolean waiting = true;

	public static void main(String[] arg) {
		new Main();
	}

	public Main() {

		SensorPort spLight = SensorPort.S1;
		SensorPort spColor = SensorPort.S2;

		int type = SensorConstants.TYPE_COLORFULL;

		colorSensor = new ColorSensor(spColor, type);
		colorSensor.setFloodlight(true);
		lightSensor = new LightSensor(spLight, true);

		Button.ENTER.addButtonListener(this);

		startScreen();
	}

	private void startScreen() {

		colorSensor.setFloodlight(Color.RED);
		System.out.print("RED: ");
		routine();
		colorSensor.setFloodlight(Color.RED);
		System.out.print("RED: ");
		routine();
		colorSensor.setFloodlight(Color.BLUE);
		System.out.print("BLUE: ");
		routine();
		colorSensor.setFloodlight(Color.BLUE);
		System.out.print("BLUE: ");
		routine();
		colorSensor.setFloodlight(Color.GREEN);
		System.out.print("GREEN: ");
		routine();
		colorSensor.setFloodlight(Color.GREEN);
		System.out.print("GREEN: ");
		routine();
		lightSensor.setFloodlight(true);
		System.out.print("ZW: ");
		rout2();
		System.out.println();
		System.out.print("ZW: ");
		rout2();
		Button.waitForAnyPress();
	}

	private void routine() {
		Button.ENTER.waitForPress();
		System.out.print(getIntensity());
		colorSensor.setFloodlight(false);
		System.out.println(" " + getIntensity());
	}

	private void rout2() {
		Button.ENTER.waitForPress();
		System.out.print(getInt());
		lightSensor.setFloodlight(false);
		System.out.print(" " + getInt());
		lightSensor.setFloodlight(true);
	}

	private void waitMS(int timeToWait) {
		try {
			Thread.sleep(timeToWait);
		} catch (InterruptedException ie) {
		}
	}

	private int getIntensity() {
		int intensity = 0;
		for (int i = 0; i < 10; i++) {
			intensity += colorSensor.getLightValue();
			waitMS(100);
		}
		intensity = intensity / 10;
		return intensity;
	}

	private int getInt() {
		int intensity = 0;
		for (int i = 0; i < 10; i++) {
			intensity += lightSensor.getLightValue();
			waitMS(100);
		}
		intensity = intensity / 10;
		return intensity;
	}

	@Override
	public void buttonPressed(Button b) {
		// TODO Auto-generated method stub
	}

	@Override
	public void buttonReleased(Button b) {
		// TODO Auto-generated method stub
	}
}