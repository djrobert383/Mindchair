package nxt;

public class LineFollowController extends Thread implements
		LightSensorListener, UltraSonicSensorListener {
	private boolean leftOnRoute;
	private boolean rightOnRoute;
	private boolean nothingInTheWay;

	public LineFollowController(ColorSensor cs, LightSensor ls,
			UltraSonicSensor us) {
		cs.addListener(this);
		ls.addListener(this);
		us.addListener(this);
		this.start();
	}

	public void run() {
		while (true) {
			if (nothingInTheWay) {
				if (!leftOnRoute) {
					MotorController.turnOnPlace(-5);
				} else if (!rightOnRoute) {
					MotorController.turnOnPlace(5);
				} else {
					MotorController.driveForward();
				}
			} else {
				MotorController.stop();
			}
		}
	}

	@Override
	public void ultraSonicChanged(UpdatingSensor us, float oldValue,
			float newValue) {
		if (newValue < 100) {
			nothingInTheWay = false;
		} else {
			nothingInTheWay = true;
		}
	}

	@Override
	public void lightSensorChanged(Position position,
			UpdatingSensor updatingsensor, float oldValue, float newValue) {
		if (position == Position.Left) {
			if (newValue < 50) {
				leftOnRoute = false;
			} else {
				leftOnRoute = true;
			}
		}
		if (position == Position.Right) {
			if (newValue < 50) {
				rightOnRoute = false;
			} else {
				rightOnRoute = true;
			}
		}
	}

}
