package nxt;

import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class MotorController {
	private final float wheelDiameter = 30;
	private final float wheelSpace = 30;
	private final NXTRegulatedMotor leftMotor = Motor.A;
	private final NXTRegulatedMotor rightMotor = Motor.B;

	private float speed;
	private DifferentialPilot differentialPilot;

	public MotorController(float speed) {
		this.speed = speed;
		differentialPilot = new DifferentialPilot(wheelDiameter, wheelSpace, leftMotor, leftMotor);
	}

	public void driveArc(float turnRadius) {
		differentialPilot.arcForward(turnRadius);
	}

	public void driveForward() {
		differentialPilot.forward();
	}

	public void stop() {
		differentialPilot.stop();
	}

	public void turnOnPlace(float degrees) {
		differentialPilot.rotate(degrees);
	}

	public void driveBackwards() {
		differentialPilot.backward();
	}
}
