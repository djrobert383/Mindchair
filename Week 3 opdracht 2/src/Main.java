import lejos.nxt.Motor;

public class Main {

	private static float WHEEL_DIAMETER = 3.6f;
	
	public Main(){
		drive(10,100);
	}

	private void drive(float speed, float distance) {
		
		float wheel_circumference = WHEEL_DIAMETER * (float) Math.PI;
		
		float degrees_to_turn = (distance / wheel_circumference) * 360;
		
		float motor_speed = ( speed / wheel_circumference ) * 360;
		
		Motor.A.setSpeed(motor_speed);
		Motor.B.setSpeed(motor_speed);
		Motor.A.rotate((int) degrees_to_turn, true);
		Motor.B.rotate((int) degrees_to_turn);

	}
	
	public static void main(String[] args) {
		new Main();
	}
}
