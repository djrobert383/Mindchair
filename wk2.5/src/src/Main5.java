package src;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;

public class Main5 {

	public static void main(String[] arg) {

		NXTRegulatedMotor motorA = Motor.getInstance(0);
		NXTRegulatedMotor motorC = Motor.getInstance(2);

		motorA.resetTachoCount();
		motorC.resetTachoCount();
		motorA.setSpeed(180);
		motorC.setSpeed(180);
		motorA.forward();
		motorC.forward();
		System.out.println("1");
		try {
			Thread.sleep(900);
		} catch (InterruptedException ie) {
		}
		
		motorA.setAcceleration(90);
		motorC.setAcceleration(90);
		motorA.setSpeed(360);
		motorC.setSpeed(360);
		System.out.println("2");
		try {
			Thread.sleep(900);
		} catch (InterruptedException ie) {
		}
		
		motorA.setAcceleration(180);
		motorC.setAcceleration(180);
		motorA.setSpeed(540);
		motorC.setSpeed(540);
		System.out.println("3");
		try {
			Thread.sleep(900);
		} catch (InterruptedException ie) {
		}
		
		System.out.println("4");
		
		motorA.stop();
		motorC.stop();
		System.out.println("5");
		int tachoCountA = motorA.getTachoCount();
		int tachoCountC = motorC.getTachoCount();

		motorC.rotateTo(tachoCountA);
		
		System.out.println("count A = " + tachoCountA + " (should be 1080)");
		System.out.println("count C = " + tachoCountC + " (should be 1080)");

		Button.waitForAnyPress();
	}
}