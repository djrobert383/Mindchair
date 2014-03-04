package xboxController;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

public class Main {
	public static Controller xbox;
	public static Component xAxis;
	public static Component yAxis;

	private float old;

	public static void main(String[] args) {
		new Main();
		new ControllerPol(xbox);
		new dataShow(xAxis, yAxis);

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
		}

	}
}