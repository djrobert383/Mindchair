package xboxController;

import net.java.games.input.Controller;

public class ControllerPol extends Thread {
	public Controller xbox;

	public ControllerPol(Controller xbox) {
		this.xbox = xbox;
		setDaemon(true);
		start();
	}

	public void run() {
		while (true) {
			xbox.poll();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
		}
	}

}
