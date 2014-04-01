package nxt;

public class ObstructionController extends Thread implements
		LightSensorListener, UltraSonicSensorListener {

	private int current_distance = 255;

	private final int SAFE_DISTANCE = 30;

	public ObstructionController(ColorSensor cs, LightSensor ls,
			UltraSonicSensor us) {
		cs.addListener(this);
		ls.addListener(this);
		us.addListener(this);
	}

	public void run() {
		while (true) {
			if (current_distance < SAFE_DISTANCE) {
				try {
					MotorController.stop();
					MotorController.turnOnPlace(90);
					MotorController.driveForward();
					Thread.sleep(1500);
					MotorController.stop();
					MotorController.turnOnPlace(-90);
					MotorController.driveForward();
					Thread.sleep(1500);
					MotorController.stop();
					MotorController.turnOnPlace(-90);
					MotorController.driveForward();
					Thread.sleep(1500);
					MotorController.turnOnPlace(90);
				} catch (InterruptedException IE) {
				}
			}
		}
	}

	@Override
	public void ultraSonicChanged(UpdatingSensor us, float oldValue,
			float newValue) {

	}

	@Override
	public void lightSensorChanged(Position position,
			UpdatingSensor updatingsensor, float oldValue, float newValue) {

	}
}