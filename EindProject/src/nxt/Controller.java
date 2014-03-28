package nxt;

public class Controller extends Thread implements LeftSensorListener,
		RightSensorListener, UltraSonicSensorListener {
	public void run() {

	}

	@Override
	public void ultraSonicChanged(UpdatingSensor us, float oldValue,
			float newValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rightSensorChanged(UpdatingSensor updatingSensor,
			float oldValue, float newValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leftSensorChanged(UpdatingSensor updatingSensor,
			float oldValue, float newValue) {
		// TODO Auto-generated method stub
		
	}
}
