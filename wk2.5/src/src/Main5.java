package src;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class Main5 {

	public static void main(String[] arg) throws InterruptedException {

		NXTRegulatedMotor motorA = Motor.getInstance(0);
		NXTRegulatedMotor motorC = Motor.getInstance(2);

		DifferentialPilot pilot = new DifferentialPilot(1.65f, 1.65f, motorA, motorC, true);
		pilot.rotate(90);
		pilot.travel(50,true);
		Thread.sleep(500);
		pilot.rotate(90);
		pilot.travel(50,true);
		Thread.sleep(500);
		pilot.rotate(90);
		pilot.travel(50,true);
		Thread.sleep(500);
		pilot.rotate(90);
		pilot.travel(50,true);
		Thread.sleep(500);
		while(pilot.isMoving())Thread.yield();
		pilot.stop();


		Button.waitForAnyPress();
	}
}