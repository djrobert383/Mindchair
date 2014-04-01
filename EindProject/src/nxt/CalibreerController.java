package nxt;

import java.util.ArrayList;

public class CalibreerController {
	private ArrayList<UpdatingSensor> sensors;

	public CalibreerController(ArrayList<UpdatingSensor> sensors) {
		this.sensors = sensors;
	}

	public void calibreer() {
		int meetWaarde;
		MotorController.turnOnPlace(360, true);
		while (MotorController.isMoving()) {
			for (UpdatingSensor sensor : sensors) {
				if (sensor.getSensorType() == SensorType.Colorsensor) {
					ColorSensor tmp = (ColorSensor) sensor;
					meetWaarde = tmp.getRawLightValue();
					if (meetWaarde < tmp.getLow()) {
						tmp.setLow(meetWaarde);
					} else if (meetWaarde > tmp.getHigh()) {
						tmp.setHigh(meetWaarde);
					}
				}
				if (sensor.getSensorType() == SensorType.Lightsensor) {
					LightSensor tmp = (LightSensor) sensor;
					meetWaarde = tmp.getLightValue();
					if (meetWaarde < tmp.getLow()) {
						tmp.setLow(meetWaarde);
					} else if (meetWaarde > tmp.getHigh()) {
						tmp.setHigh(meetWaarde);
					}
				}
			}
		}
	}
}
