package opdracht4;

import java.util.ArrayList;

public class SensorHandler extends Thread {
	private static SensorHandler singleton = null;
	private ArrayList<UpdatingSensor> theSensors = new ArrayList<UpdatingSensor>();
	private int PERIOD = 10;

	private SensorHandler() {
		this.setDaemon(true);
		start();
	}

	public void run() {
		while (true) {
			try {
				synchronized (this) {
					for (UpdatingSensor sensor : theSensors)
						sensor.updateState();
				}
				Thread.sleep(PERIOD);
			} catch (InterruptedException exception) {
			}
		}
	}

	public static SensorHandler getInstance() {
		if (singleton == null) {
			singleton = new SensorHandler();
		}
		return singleton;

	}

	public void addSensor(UpdatingSensor sensor) {
		theSensors.add(sensor);
	}
}
