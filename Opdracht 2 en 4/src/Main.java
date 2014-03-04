import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class Main {
	public ColorSensor cs;
	public LightSensor ls;
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		cs = new ColorSensor(SensorPort.S2);
		ls = new LightSensor(SensorPort.S1);
		System.out.println("Geef een witte ");
		System.out.println("ondergrond");
		
		System.out.println("en druk op enter");
		Button.ENTER.waitForPress();
		cs.calibrateHigh();
		ls.calibrateHigh();
		LCD.clear();
		System.out.println("color sensor waarde: "+cs.getHigh());
		System.out.println("light sensor waarde: "+ls.getHigh());
		System.out.println();
		System.out.println("druk op enter om verder te gaan");
		Button.ENTER.waitForPress();
		
		System.out.println("Geef een zwarte ondergrond");
		System.out.println("en druk op enter");
		Button.ENTER.waitForPress();
		cs.calibrateLow();
		ls.calibrateLow();
		LCD.clear();
		System.out.println("color sensor waarde: "+cs.getLow());
		System.out.println("light sensor waarde: "+ls.getLow());
		System.out.println();
		System.out.println("druk op enter om verder te gaan");
		Button.ENTER.waitForPress();
		
	}
}
