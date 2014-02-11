package src;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;

public class Main5 {

	public static void main(String[] arg) {
		NXTRegulatedMotor motorA = Motor.getInstance(0);
		NXTRegulatedMotor motorC = Motor.getInstance(2);

		Motor.B.lock(180);
		motorA.resetTachoCount();
		motorC.resetTachoCount();
		motorA.setAcceleration(150);
		motorC.setAcceleration(150);
		motorA.setSpeed(360);
		motorC.setSpeed(360);
		motorA.rotateTo(1080);
		motorC.rotateTo(1080);
		motorA.forward();
		motorC.forward();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {}

		motorA.stop();
		motorC.stop();
		int tachoCountA = motorA.getTachoCount();
		int tachoCountC = motorC.getTachoCount();
		System.out.println("count A = " + tachoCountA + " (should be 1080)");
		System.out.println("count C = " + tachoCountC + " (should be 1080)");

		Button.waitForAnyPress();
	}
}