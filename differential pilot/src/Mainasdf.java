import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;


public class Mainasdf {
	public static void main(String[] args){
		UltrasonicSensor s = new UltrasonicSensor(SensorPort.S4);
		while(true){
			System.out.println(s.getDistance());		
		}
	}
}
