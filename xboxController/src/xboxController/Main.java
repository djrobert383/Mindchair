package xboxController;

import net.java.games.input.*;

public class Main {
	public Controller xbox;
	private Component xAxis;
	private Component yAxis;

	private float old;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		Controller[] ca = ControllerEnvironment.getDefaultEnvironment()
				.getControllers();
		for (int i = 0; i < ca.length; i++) {
			if (ca[i].getName().equals(
					"Controller (Xbox 360 Wireless Receiver for Windows)")) {
				xbox = ca[i];
			}
		}
		if (xbox != null) {
			Component[] components = xbox.getComponents();
			for (int i = 0; i < components.length; i++) {
				System.out.println(components[i].getName());
				if (components[i].getName().equals("Y Axis")) {
					yAxis = components[i];
				}
				if (components[i].getName().equals("X Axis")) {
					xAxis = components[i];
				}
			}
			System.out.println(yAxis.getDeadZone());
			System.out.println(yAxis.getName());
			for(int i = 0; i< 5000; i++){
				
			}
		}

	}
}