package nxt;

public class LineFollowController extends Thread implements LightSensorListener {
	private boolean leftOnRoute;
	private boolean rightOnRoute;
	private boolean nothingInTheWay;	
	//private final int MINIMUM_SAFE_DISTANCE = 50;
	private static boolean pause;

	public LineFollowController(ColorSensor cs, LightSensor ls) {
		pause = false;
		cs.addListener(this);
		ls.addListener(this);
		this.start();

	}

	public void run() {
		while (true) {
			if (!pause) {
				if (nothingInTheWay) {
					if (!leftOnRoute) {
						MotorController.turnOnPlace(-5, false);
					} else if (!rightOnRoute) {
						MotorController.turnOnPlace(5, false);
					} else {
						MotorController.driveForward();
					}
				} else {
					MotorController.driveForward();
				}
			} else {
				MotorController.stop();
			}
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
