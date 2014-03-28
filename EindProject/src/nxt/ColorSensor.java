package nxt;

import java.util.ArrayList;

import lejos.nxt.SensorPort;

public class ColorSensor extends lejos.nxt.ColorSensor implements
		UpdatingSensor {
	private float value;
	private ArrayList<LeftSensorListener> leftlisteners = new ArrayList<LeftSensorListener>();
	private ArrayList<RightSensorListener> rightlisteners = new ArrayList<RightSensorListener>();

	public ColorSensor(SensorPort sensorport) {
		super(sensorport);
	}

	public void updateState() {
		float tmp = getRawLightValue();
		if (tmp != value) {
			if (leftlisteners.size() < 0) {
				for (LeftSensorListener lsl : leftlisteners) {
					lsl.leftSensorChanged(this, value, tmp);
				}
			}
			if (rightlisteners.size() < 0) {
				for (RightSensorListener rsl : rightlisteners) {
					rsl.rightSensorChanged(this, value, tmp);
				}
			}
			value = tmp;
		}

	}

	public void addRightListener(RightSensorListener rsl) {
		rightlisteners.add(rsl);
	}

	public void addLeftListener(LeftSensorListener lsl) {
		leftlisteners.add(lsl);
	}

	public void deleteRightListener(RightSensorListener rsl) {
		boolean tmp = rightlisteners.remove(rsl);

		if (tmp) {
			System.out.println("removed");
		} else {
			System.err.print("not removed");
		}
	}

	public void deleteLeftListener(RightSensorListener rsl) {
		boolean tmp = leftlisteners.remove(rsl);

		if (tmp) {
			System.out.println("removed");
		} else {
			System.err.print("not removed");
		}
	}
}
