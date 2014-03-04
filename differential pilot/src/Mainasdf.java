import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;


public class Mainasdf {
	public static void main(String[] args){
		UltrasonicSensor s = new UltrasonicSensor(SensorPort.S4);
		DifferentialPilot dp = new DifferentialPilot(30, 30, Motor.B, Motor.A);
		dp.setTravelSpeed(2500);
		dp.forward();
		while(true){
			System.out.println(s.getDistance());
			if(s.getDistance()<200){
				dp.stop();
				break;
			}
			
		}
		Button.waitForAnyPress();
	}
}
