import lejos.nxt.Motor;
import lejos.robotics.navigation.Move;

public class Main2 {
	public final int wheelDiameter = 35;

	public static void main(String[] args) {
		new Main2();

	}

	public Main2() {
		drive(10, 50);

	}

	public void drive(float velocity, float space) {
		space = space * 10;
		double angle = (space / (360 / (2 * Math.PI * (wheelDiameter / 2))));

		velocity = velocity * 10;
		velocity = (float) (360 / (2 * Math.PI * (wheelDiameter / 2)) * velocity);
		Motor.A.setSpeed(velocity);
		Motor.B.setSpeed(velocity);
		Motor.A.rotate((int) angle, true);
		Motor.B.rotate((int) angle);
	}

}
