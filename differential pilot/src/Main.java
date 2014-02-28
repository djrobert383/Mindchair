import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class Main implements ButtonListener {
	public DifferentialPilot diferentialPilot;
	public final int wheelDiameter = 35;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		diferentialPilot = new DifferentialPilot(wheelDiameter, 160, Motor.B,
				Motor.A);
		System.out.println("Circel met straal 20 cm");
		Button.waitForAnyPress();
		driveArc(200);
		LCD.clear();
		
		
		System.out.println("50 cm vooruit");
		System.out.println("snelheid 10 cm/s");
		Button.waitForAnyPress();
		drive(10,50);
		LCD.clear();
		
		System.out.println("halve circel");
		System.out.println("straal 20");
		System.out.println("snelheid 10 cm/s");
		Button.waitForAnyPress();
		driveCircle(10,20,0.5f);
		LCD.clear();
		
		System.out.println("Vierkant met zijden van 50 cm");
		Button.waitForAnyPress();
		drive360(4,500f);
		LCD.clear();
		
		System.out.println("Vooruit als je escape ingedrukt houd");
		System.out.println("");
		System.out.println("Sluit af als je op enter drukt");
		Button.waitForAnyPress();
		Button.ESCAPE.addButtonListener(this);
		Button.ENTER.waitForPress();
	}

	/*
	 * gebruikte eenheden voor functie driveArc straal in mm
	 */
	public void driveArc(double turnRadius) {
		diferentialPilot.arcForward(turnRadius);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * gebruikte eenheden voor functie drive snelheid in cm/s afstand in cm
	 */
	public void drive(float velocity, float space) {
		space = space * 10;
		velocity = velocity * 10;
		diferentialPilot.setTravelSpeed(velocity);
		diferentialPilot.travel(space);
	}

	public void driveCircle(float velocity, float radius, float fraction) {
		velocity = velocity * 10;
		radius = radius * 10;
		float angle = fraction * 360;
		diferentialPilot.setTravelSpeed(velocity);

		diferentialPilot.arc(radius, angle);
	}

	public void drive360(int sides, float sideDistance) {
		for (int i = 0; i < sides; i++) {
			diferentialPilot.travel(sideDistance);
			diferentialPilot.rotate((360/sides));
		}

	}

	@Override
	public void buttonPressed(Button b) {
		diferentialPilot.forward();

	}

	@Override
	public void buttonReleased(Button b) {
		diferentialPilot.stop();

	}

}
