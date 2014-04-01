package nxt;

import java.util.ArrayList;

public class CalibreerController {

	private int _high;
	private int _low;
	private ArrayList<UpdatingSensor> sensors;

	public CalibreerController(ArrayList<UpdatingSensor> sensors) {
		this.sensors = sensors;
	}

	public void calibreer() {
		for (int graden = 0; graden < 360; graden++) {
			MotorController.turnOnPlace(1);
			for(UpdatingSensor sensor : sensors){
				if(sensor.getSensorType() == SensorType.Colorsensor){
					((ColorSensor) sensor).getNormalizedLightValue();
				}
			}
		}
	}
}
