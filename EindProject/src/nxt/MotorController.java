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
	}

	public void driveArc(float turnRadius) {

	}

	public void driveForward() {

	}

	public void stop() {

	}

	public void turnOnPlace(float degrees) {

	}

	public void driveBackwards() {

	}
}
