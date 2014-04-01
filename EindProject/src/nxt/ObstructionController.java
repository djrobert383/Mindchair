package nxt;

public class ObstructionController extends Thread implements LightSensorListener, UltraSonicSensorListener{
	
	
	
	public ObstructionController(ColorSensor cs, LightSensor ls,
			UltraSonicSensor us) {
		cs.addListener(this);
		ls.addListener(this);
		us.addListener(this);
	}
	
	public void run(){
		
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